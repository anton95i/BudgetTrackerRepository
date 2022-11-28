<template>
  <div id="contentContainer" class="signupcontentContainer container rounded-lg mt-3 shadow-lg p-3 mb-5 bg-white rounded">
    <h2>Statistic:</h2>
    <br />
    <div>
      <b-row>
        <b-col>
          <b-row class="lowerRow">
            <b-col>
              <label for="firtname" class="disabled-input-show">Name:</label>
          <b-form-input v-model="name" type="text" class="form-control" id="name" name="name" placeholder="Name" disabled />
            </b-col>
            <b-col>
              <label for="email" label-align="left" class="disabled-input-show">E-Mail:</label>
              <b-form-input v-model="email" type="email" class="form-control" id="email" name="email" placeholder="Email" disabled />
            </b-col>
            <b-col>
              <label for="status" label-align="left" class="disabled-input-show">Usertype:</label>
              <b-form-input v-model="userType" type="text" class="form-control" id="usertype" name="usertype" placeholder="Usertype" disabled />
            </b-col>
          </b-row>
          <b-table id="my-table" :items="statisticTable" :fields="fieldsStatistic" :per-page="perPage" :current-page="currentPage" striped responsive small></b-table>
          <b-pagination
            class="customPagination"
            v-model="currentPage"
            :total-rows="rows"
            :per-page="perPage"
            aria-controls="my-table"
            size="sm"
            pills
            align="center"
          ></b-pagination>
          <h4>Abos</h4>
          <b-table id="my-table2" :items="abosTable" :fields="fieldsAbos" :per-page="perPage2" :current-page="currentPage2" striped responsive small></b-table>
          <!--
          <b-pagination
            class="customPagination"
            v-model="currentPage2"
            :total-rows="rows2"
            :per-page="perPage2"
            aria-controls="my-table2"
            size="sm"
            pills
            align="center"
          ></b-pagination>
          -->
        </b-col>
      </b-row>
      <br />
    </div>
  </div>
</template>

<script>
export default {
  name: "StatisticView",
  props: {
    msg: String,
  },
  data() {
    return {
      name: "fakename",
      email: "fakeemail",
      userType: "fakeusertype",
      jwtConfig: {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("token"),
        },
      },
      incomeAndExpenses: [],
      balance: null,
      balanceRaw: null,
      balanceThisMonth: 0,
      balanceThisMonthRaw: 0,
      rows: 0,
      rows2: 0,
      perPage: 12,
      perPage2: 12,
      currentPage: 1,
      currentPage2: 1,
      statisticTable: [],
      abosTable: [],
      fieldsStatistic: [
        { key: "month", label: "Month" },
        { key: "income", label: "Income", formatter: this.formatMoney },
        { key: "expenses", label: "Expenses", formatter: this.formatMoney },
        { key: "total", label: "Total", formatter: this.formatMoney },
      ],
      fieldsAbos: [
        { key: "name", label: "Name" },
        { key: "price", label: "Price", formatter: this.formatMoney },
        { key: "pricePerYear", label: "Price/Year", formatter: this.formatMoney },
        { key: "recurring", label: "Type" },
      ],
    };
  },
  async mounted() {
    //var date = new Date();
    //var month = date.getMonth() + 1;
    await this.$axios
      .get(this.$apiUrl + "/incomeAndExpenses", this.jwtConfig)
      .then((responseProducts) => {
        this.incomeAndExpenses = responseProducts.data;
        this.rows = this.incomeAndExpenses.length;
        this.calculateStatisticTable();
      })
      .catch((error) => {
        console.log(error);
        if (localStorage.getItem("token") == null) {
          this.$router.push({ name: "login" });
        }
      });
  },
  methods: {
    formatMoney(value) {
      // check if value is double
      if (typeof value === "number") {
        return value.toFixed(2) + " €";
      } else {
        return value + " €";
      }
    },
    calculateStatisticTable() {
      this.statisticTable = [];
      this.incomeAndExpenses.forEach((element) => {
        var month = element.date.split("-")[1];
        var year = element.date.split("-")[0];
        var found = false;
        this.statisticTable.forEach((element2) => {
          if (element2.month == month + "/" + year) {
            found = true;
            if (element.type == "INCOME") {
              element2.income += element.amount;
            } else {
              element2.expenses += element.amount;
            }
            element2.total = element2.income - element2.expenses;
          }
        });
        if (!found) {
          if (element.type == "INCOME") {
            this.statisticTable.push({
              month: month + "/" + year,
              income: element.amount,
              expenses: 0,
              total: element.amount,
            });
          } else {
            this.statisticTable.push({
              month: month + "/" + year,
              income: 0,
              expenses: element.amount,
              total: 0 - element.amount,
            });
          }
        }
        if (element.abo == true) {
          var foundAbo = false;
          this.abosTable.forEach((element2) => {
            if (element2.name == element.title) {
              foundAbo = true;
            }
          });
          if (!foundAbo) {
            var recurring = null;
            if (element.aboInterval == 12) {
              recurring = "Montly";
            } else if (element.aboInterval == 1) {
              recurring = "Yearly";
            } else if (element.aboInterval == 4) {
              recurring = "Quarterly";
            } else if (element.aboInterval == 6) {
              recurring = "Half Yearly";
            }
            this.abosTable.push({
              name: element.title,
              price: element.amount,
              pricePerYear: element.amount * element.aboInterval,
              recurring: recurring,
            });
          }
        }
      });
      this.rows = this.statisticTable.length;
    },
  },
};
</script>

<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
.form-control:disabled {
  background-color: #fff;
  color: #000;
  font-weight: 550;
  border: none;
}
.disabled-input-show {
  margin-bottom: 0px;
  float: left;
}
</style>
