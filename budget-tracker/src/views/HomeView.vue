<template>
  <div id="contentContainer" class="container rounded-lg mt-3 shadow-lg p-3 mb-5 bg-white rounded">
    <div class="home">
      <b-row>
        <b-col cols="2">
          <img alt="Auction Hammer" src="../assets/logo2.png" width="70%" />
        </b-col>
        <b-col>
          <h1 style="padding-right: 23%; padding-top: 20px;">Expenses and Income</h1>
        </b-col>
      </b-row>
      <div v-if="showAuctions == false">
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
      <b-container fluid v-if="showAuctions == true">
        <!--<p class="mt-3">Current Page: {{ currentPage }}</p>-->
        <b-row style="margin-bottom: 5px;">
          <b-col lg="8" class="my-1">
            <b-form-group style="float: right; width: 50%;">
              <b-input-group size="sm">
                <b-form-input id="filter-input" v-model="filter" type="search" placeholder="Type to Search"></b-form-input>
                <b-input-group-append>
                  <b-button style="border: none !important" :disabled="!filter" @click="filter = ''">Clear</b-button>
                </b-input-group-append>
              </b-input-group>
            </b-form-group>
          </b-col>
          <b-col lg="4" class="my-1">
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
          </b-col>
        </b-row>
        <b-table
          id="my-table"
          :items="auctions"
          :fields="fields"
          :per-page="perPage"
          :current-page="currentPage"
          :sort-by.sync="sortBy"
          :sort-desc.sync="sortDesc"
          :show-sort-icons="true"
          sort-icon-left
          striped
          responsive
          hover
          small
          label-sort-asc=""
          label-sort-desc=""
          label-sort-clear=""
          :filter="filter"
          @row-clicked="onRowClicked"
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
      showAuctions: false,
      timer: null,
      perPage: 12,
      currentPage: 1,
      sortBy: "timeLeft",
      sortDesc: false,
      filter: null,
      filterOn: [],
      fields: [
        { key: "product", label: "Product", sortable: true },
        { key: "title", label: "Name", sortable: true },
        { key: "timeLeft", label: "Time Left", sortable: true },
        { key: "deliveryDate", label: "Delivery Date", sortable: true },
        { key: "minAmount", label: "Min Amount", sortable: false },
        { key: "startingPrice", label: "Max Price", sortable: false },
        { key: "lowestBid", label: "Lowest Bid", sortable: false },
        { key: "status", label: "Status", sortable: false },
        { key: "amountBids", label: "Bids", sortable: false },
      ],
      auctions: [],
      products: [],
      bids: [],
    };
  },
  created: function () {
    this.timer = setInterval(() => {
      this.decreaseTimeLeft();
    }, 1000);
  },
  methods: {
    onRowClicked(row) {
      this.$router.push({ name: "auction", params: { auction: row } });
    },
    async decreaseTimeLeft() {
      this.auctions.forEach((auction) => {
        auction.timeLeftRaw = auction.timeLeftRaw - 1000;
        auction.timeLeft = this.calculateTimeLeft(auction.timeLeftRaw);
      });
      const newAuctions = this.auctions;
      this.auctions = [];
      this.auctions = newAuctions;
    },
    calculateTimeLeft(timeLeft) {
      const days = Math.floor(timeLeft / (1000 * 60 * 60 * 24));
      const hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      const minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
      const seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);
      if (timeLeft < 0) {
        return "Auction Ended";
      } else {
        return `${days}d ${hours}h ${minutes}m ${seconds}s`;
      }
    },
  },
  async mounted() {
    await this.$axios.get(this.$apiUrl + "/product").then((responseProducts) => {
      if (localStorage.getItem("token") != null) {
        this.$axios.get(this.$apiUrl + "/auction", this.jwtConfig).then((responseAuctions) => {
          this.$axios.get(this.$apiUrl + "/bid").then((responseBids) => {
            this.auctions = responseAuctions.data;
            responseAuctions.data.forEach((auction) => {
              if(auction.userId == localStorage.getItem("userId")){
                auction._rowVariant = "info";
              }
              if(auction.status == "LOCKED"){
                auction._rowVariant = "danger";
              }
              auction.amountBids = 0;
              auction.lowestBid = null;
              responseBids.data.forEach((bid) => {
                if (auction.id === bid.auctionId) {
                  auction.amountBids++;
                  if (auction.lowestBid === null) {
                    auction.lowestBid = bid.price;
                  } else if (auction.lowestBid > bid.price) {
                    auction.lowestBid = bid.price;
                  }
                }
              });
              if (auction.lowestBid != null) {
                auction.lowestBid = "€ " + auction.lowestBid.toFixed(2);
              }
              const timeLeft = new Date(auction.endDate) - new Date();
              auction.timeLeftRaw = timeLeft;
              auction.timeLeft = this.calculateTimeLeft(timeLeft);
              auction.startingPriceRaw = auction.startingPrice;
              auction.startingPrice = "€ " + auction.startingPrice.toFixed(2);
              const deliveryDate = new Date(auction.deliveryDate);
              auction.deliveryDateRaw = deliveryDate;
              auction.deliveryDate = `${deliveryDate.getDate()}.${deliveryDate.getMonth() + 1}.${deliveryDate.getFullYear()}`;
              responseProducts.data.forEach((product) => {
                if (product.id == auction.productId) {
                  auction.product = product.name;
                }
              });
            });
          });
        });
      } else {
        this.$axios.get(this.$apiUrl + "/auction").then((responseAuctions) => {
          this.$axios.get(this.$apiUrl + "/bid").then((responseBids) => {
            this.auctions = responseAuctions.data;
            responseAuctions.data.forEach((auction) => {
              auction.amountBids = 0;
              auction.lowestBid = null;
              responseBids.data.forEach((bid) => {
                if (auction.id === bid.auctionId) {
                  auction.amountBids++;
                  if (auction.lowestBid === null) {
                    auction.lowestBid = bid.price;
                  } else if (auction.lowestBid > bid.price) {
                    auction.lowestBid = bid.price;
                  }
                }
              });
              if (auction.lowestBid != null) {
                auction.lowestBid = "€ " + auction.lowestBid.toFixed(2);
              }
              const timeLeft = new Date(auction.endDate) - new Date();
              auction.timeLeftRaw = timeLeft;
              auction.timeLeft = this.calculateTimeLeft(timeLeft);
              auction.startingPrice = "€ " + auction.startingPrice.toFixed(2);
              const deliveryDate = new Date(auction.deliveryDate);
              auction.deliveryDate = `${deliveryDate.getDate()}.${deliveryDate.getMonth() + 1}.${deliveryDate.getFullYear()}`;
              responseProducts.data.forEach((product) => {
                if (product.id == auction.productId) {
                  auction.product = product.name;
                }
              });
            });
          });
        });
      }
      this.showAuctions = true;
    });
  },
  computed: {
    rows() {
      return this.auctions.length;
    },
  },
  beforeDestroy() {
    clearInterval(this.timer);
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
</style>
