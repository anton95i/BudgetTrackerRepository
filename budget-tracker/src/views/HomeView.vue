<template>
  <div id="contentContainer" class="container rounded-lg mt-3 shadow-lg p-3 mb-5 bg-white rounded">
    <div class="home">
      <b-row>
        <b-col cols="2">
          <img alt="Cash Logo" src="../assets/logo2.png" width="70%" />
        </b-col>
        <b-col>
          <h1 style="padding-right: 2%; padding-top: 20px">Expenses and Income</h1>
        </b-col>
        <b-col cols="2" v-if="showIncomeAndExpenses == true">
          <b-row>
            <label for="balance" class="disabled-input-show">Balance:</label>
            <b-form-input v-model="balance" type="text" class="form-control" id="balance" name="balance" placeholder="Balance" disabled />
          </b-row>
          <b-row>
            <label for="balanceThisMonth" class="disabled-input-show">This Month:</label>
            <b-form-input v-model="balanceThisMonth" type="text" class="form-control" id="balanceThisMonth" name="balanceThisMonth" placeholder="This month" disabled />
          </b-row>
        </b-col>
      </b-row>
      <div v-if="showIncomeAndExpenses == false">
        <div class="lds-roller">
          <div></div>
          <div></div>
          <div></div>
          <div></div>
          <div></div>
          <div></div>
          <div></div>
          <div></div>
        </div>
      </div>
      <b-container fluid v-if="showIncomeAndExpenses == true">
        <!--<p class="mt-3">Current Page: {{ currentPage }}</p>-->
        <b-row style="margin-bottom: 5px">
          <b-col lg="8" class="my-1">
            <b-form-group style="float: right; width: 50%">
              <b-input-group size="sm">
                <b-form-input id="filter-input" v-model="filterVarOne" type="search" placeholder="Type to Search" @change="toggleFilter"></b-form-input>
                <b-input-group-append>
                  <b-button style="border: none !important" :disabled="!filterVarOne" @click="filterVarOne = ''">Clear</b-button>
                </b-input-group-append>
              </b-input-group>
            </b-form-group>
          </b-col>
          <b-col lg="4" class="my-1">
            <b-form-select id="initial-sort-select" v-model="filterVarTwo" :options="filterOptions" size="sm" @change="toggleFilter"></b-form-select>
            <!--
            <b-pagination
              class="customPagination mobilePagination"
              v-model="currentPage"
              :total-rows="rows"
              :per-page="perPage"
              aria-controls="my-table"
              size="sm"
              pills
              align="right"
            ></b-pagination>
            -->
          </b-col>
        </b-row>
        <b-table
          id="my-table"
          :items="incomeAndExpenses"
          :fields="fields"
          :per-page="perPage"
          :current-page="currentPage"
          :sort-by.sync="sortBy"
          :sort-desc.sync="sortDesc"
          :show-sort-icons="true"
          :custom-foot="foot"
          sort-icon-left
          striped
          responsive
          hover
          small
          label-sort-asc=""
          label-sort-desc=""
          label-sort-clear=""
          :filter="filter"
          :filter-function="filterFunction"
          @row-clicked="onRowClicked"
          @filtered="onFiltered"
        ></b-table>
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
      </b-container>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomeView",
  data() {
    return {
      jwtConfig: {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("token"),
        },
      },
      showIncomeAndExpenses: false,
      timer: null,
      rows: 0,
      perPage: 14,
      currentPage: 1,
      sortBy: "date",
      sortDesc: true,
      filter: " ",
      filterVarOne: null,
      filterVarTwo: null,
      filterOptions: [
        { value: null, text: "All Categories" },
        { value: "FOOD", text: "Food" },
        { value: "CLOTHES", text: "Clothes" },
        { value: "ENTERTAINMENT", text: "Entertainment" },
        { value: "HOUSING", text: "Housing" },
        { value: "TRANSPORTATION", text: "Transportation" },
        { value: "HEALTH", text: "Health" },
        { value: "EDUCATION", text: "Education" },
        { value: "SAVINGS", text: "Savings" },
        { value: "SALARY", text: "Salary" },
        { value: "OTHER", text: "Other" },
      ],
      fields: [
        { key: "amount", label: "Amount", sortable: true, class: "amountCustomClass" },
        { key: "title", label: "Title", sortable: true },
        { key: "category", label: "Category", sortable: true },
        { key: "date", label: "Date", sortable: true, formatter: this.formatDate },
      ],
      foot: [
        {
          amount: "Total",
          title: this.totalAmount,
          category: "",
          date: "",
        },
      ],
      incomeAndExpenses: [],
      balance: null,
      balanceRaw: null,
      balanceThisMonth: 0,
      balanceThisMonthRaw: 0,
    };
  },
  methods: {
    onFiltered(filteredItems) {
      this.rows = filteredItems.length;
      this.currentPage = 1;
    },
    filterFunction(item, filter) {
      if (this.filterVarOne != null) {
        filter = this.filterVarOne;
      } else {
        filter = "";
      }
      return Object.keys(item).some((key) => {
        if (this.filterVarTwo == null) {
          return String(item[key]).toLowerCase().includes(filter.toLowerCase());
        } else {
          return String(item[key]).toLowerCase().includes(filter.toLowerCase()) && item.category == this.filterVarTwo;
        }
      });
    },
    toggleFilter() {
      this.filter = this.filterVarOne + this.filterVarTwo;
    },
    onRowClicked(row) {
      this.$router.push({ name: "incomeAndExpenses", params: { incomeAndExpenses: row } });
    },
    formatDate(value) {
      if (!value) return "";
      return new Date(value).toLocaleDateString("de-DE", {
        year: "numeric",
        month: "2-digit",
        day: "2-digit",
      });
    },
  },
  async mounted() {
    var date = new Date();
    var month = date.getMonth() + 1;
    await this.$axios
      .get(this.$apiUrl + "/incomeAndExpenses", this.jwtConfig)
      .then((responseProducts) => {
        this.incomeAndExpenses = responseProducts.data;
        this.incomeAndExpenses.forEach((element) => {
          element.amountRaw = element.amount;
          if (element.type == "INCOME") {
            element._rowVariant = "success";
            element.amount = "+" + element.amount.toFixed(2) + " €";
          } else {
            element._rowVariant = "danger";
            element.amountRaw = 0 - element.amount;
            element.amount = "-" + element.amount.toFixed(2) + " €";
          }
          this.balance += element.amountRaw;
          if (element.date.split("-")[1] == month) {
            this.balanceThisMonthRaw += element.amountRaw;
            this.balanceThisMonth = this.balanceThisMonthRaw.toFixed(2) + " €";
          }
        });
        this.showIncomeAndExpenses = true;
        this.balanceRaw = this.balance;
        this.balance = this.balance.toFixed(2) + " €";
        this.rows = this.incomeAndExpenses.length;
      })
      .catch((error) => {
        console.log(error);
        if (localStorage.getItem("token") == null) {
          this.$router.push({ name: "login" });
        }
      });
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
  text-align: left;
}
.lowerRow {
  margin-top: 10px;
}
</style>
