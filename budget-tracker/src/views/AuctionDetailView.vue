<template>
  <div id="contentContainer" class="signupcontentContainer container rounded-lg mt-3 shadow-lg p-3 mb-5 bg-white rounded">
    <h6 v-if="showSuccess">Successfully...</h6>
    <div>
      <b-row>
        <b-col cols="4">
          <img v-if="base64Picture === false" alt="Profile Picture" :src="getImgUrl(imgPath)" />
          <img v-if="base64Picture === true" alt="Profile Picture" :src="imgBase64" />
        </b-col>
        <b-col>
          <b-row class="lowerRow">
            <b-col>
              <label for="productName" class="disabled-input-show">Product Name:</label>
              <b-form-input v-model="productName" type="text" class="form-control" id="productName" name="productName" placeholder="Product Name" disabled />
            </b-col>
            <b-col>
              <label for="productPrice" label-align="left" class="disabled-input-show">Price:</label>
              <b-form-input v-model="productPrice" type="text" class="form-control" id="productPrice" name="productPrice" placeholder="Price" disabled />
            </b-col>
          </b-row>
          <b-row class="lowerRow">
            <b-col>
              <label for="productDescription" label-align="left" class="disabled-input-show">Description:</label>
              <b-form-textarea id="textarea" v-model="productDescription" placeholder="Description" rows="4" max-rows="6" disabled></b-form-textarea>
            </b-col>
          </b-row>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-row class="lowerRow">
            <b-col cols="6">
              <label for="title" class="disabled-input-show">Title:</label>
              <b-form-input v-model="title" type="text" class="form-control" id="title" name="title" placeholder="Title" disabled />
            </b-col>
            <b-col>
              <label for="timeLeft" class="disabled-input-show">Time Left:</label>
              <b-form-input v-model="timeLeft" type="text" class="form-control" id="timeLeft" name="timeLeft" placeholder="Time Left" disabled />
            </b-col>
            <b-col>
              <label for="deliveryDate" class="disabled-input-show">Delivery Date:</label>
              <b-form-input v-model="deliveryDate" type="text" class="form-control" id="deliveryDate" name="deliveryDate" placeholder="Delivery Date" disabled />
            </b-col>
          </b-row>
          <b-row class="lowerRow">
            <b-col>
              <label for="status" class="disabled-input-show">Status:</label>
              <b-form-input v-model="status" type="text" class="form-control" id="status" name="status" placeholder="Status" disabled />
            </b-col>
            <b-col>
              <label for="minAmount" class="disabled-input-show">Min Amount:</label>
              <b-form-input v-model="minAmount" type="text" class="form-control" id="minAmount" name="minAmount" placeholder="Min Amount" disabled />
            </b-col>
            <b-col>
              <label for="maxPrice" class="disabled-input-show">Max Price:</label>
              <b-form-input v-model="maxPrice" type="text" class="form-control" id="maxPrice" name="maxPrice" placeholder="Max Price" disabled />
            </b-col>
            <b-col>
              <label for="amountBids" class="disabled-input-show">Bids:</label>
              <b-form-input v-model="amountBids" type="text" class="form-control" id="amountBids" name="amountBids" placeholder="Bids" disabled />
            </b-col>
          </b-row>
          <b-row class="lowerRow">
            <b-table
              v-if="showBidsTable === true"
              id="my-table"
              :items="bids"
              :fields="fields"
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
          </b-row>
        </b-col>
      </b-row>
      <b-row v-if="showButtons === true">
        <b-col>
          <b-button @click="initBid()" class="button-profile btn btn-lg btg-dark btn-block" type="submit" name="login">Bid</b-button>
        </b-col>
      </b-row>
      <b-row v-if="userId == auction.userId && this.auction.status == 'CLOSED'">
        <b-col>
          <b-form-input value="CLICK on row to accept Bid!" class="form-control" placeholder="Max Price" style="text-align: center" disabled />
        </b-col>
      </b-row>
      <b-row v-if="userId == auction.userId">
        <b-col>
          <b-form-input value="This is your auction!" class="form-control" placeholder="Max Price" style="text-align: center" disabled />
        </b-col>
      </b-row>
      <b-form id="createBid" v-if="showCreateBid === true">
        <b-row>
          <b-col cols="2">
            <label for="newPrice">Price</label>
            <b-form-input @change="calculateNewPricePerUnit()" v-model="newPrice" type="number" class="form-control" id="newPrice" name="newPrice" placeholder="Price" />
            <label v-if="showErrorMessageNewPrice === true" style="color: red" for="newPrice">Price too high!</label>
          </b-col>
          <b-col cols="2">
            <label for="newAmount">Amount</label>
            <b-form-input
              @change="calculateNewPricePerUnit()"
              v-model="newAmount"
              type="number"
              class="form-control"
              id="newAmount"
              name="newAmount"
              placeholder="Amount"
            />
            <label v-if="showErrorMessageNewAmount === true" style="color: red" for="newAmount">Amount too low!</label>
          </b-col>
          <b-col cols="6">
            <label for="newDeliveryDate">Delivery Date</label>
            <b-form-datepicker
              @change="calculateNewPricePerUnit()"
              v-model="newDeliveryDate"
              type="date"
              class="form-control"
              id="newDeliveryDate"
              name="newDeliveryDate"
              placeholder="Delivery Date"
            />
            <label v-if="showErrorMessageNewDeliveryDate === true" style="color: red" for="newPrice">Please enter a future date!</label>
          </b-col>
          <b-col>
            <label for="newPricePerUnit">€/Unit</label>
            <b-form-input v-model="newPricePerUnit" type="text" class="form-control" id="newPricePerUnit" name="newPricePerUnit" placeholder="Amount" disabled />
          </b-col>
        </b-row>
        <br />
        <b-button @click="createBid()" class="btn btn-lg btg-dark btn-block" name="login">Submit</b-button>
      </b-form>
    </div>
    <ModalMain :title="modalTitleText" :body="modalBodyText" ref="modalName" />
  </div>
</template>

<script>
import ModalMain from "../components/modal-main.vue";
export default {
  name: "RegisterView",
  components: {
    ModalMain,
  },
  data() {
    return {
      userId: localStorage.getItem("userId"),
      jwtConfig: {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("token"),
        },
      },
      modalTitleText: "ERROR",
      modalBodyText: "",
      sortDesc: false,
      filter: null,
      imgPath: "default_picture.jpg",
      imgBase64: "",
      sortBy: "pricePerUnit",
      showSuccess: false,
      showButtons: true,
      showCreateBid: false,
      showBidsTable: false,
      showErrorMessageNewPrice: false,
      showErrorMessageNewAmount: false,
      showErrorMessageNewDeliveryDate: false,
      base64Picture: false,
      newImage: null,
      auction: this.$route.params.auction,
      title: this.$route.params.auction.title,
      deliveryDate: this.$route.params.auction.deliveryDate,
      deliveryDateRaw: this.$route.params.auction.deliveryDateRaw,
      status: this.$route.params.auction.status,
      productId: this.$route.params.auction.productId,
      timeLeft: this.$route.params.auction.timeLeft,
      endDate: this.$route.params.auction.endDate,
      timeLeftRaw: this.$route.params.auction.timeLeftRaw,
      maxPrice: this.$route.params.auction.startingPrice,
      maxPriceRaw: this.$route.params.auction.startingPriceRaw,
      minAmount: this.$route.params.auction.minAmount,
      amountBids: this.$route.params.auction.amountBids,
      newPrice: "",
      newAmount: "",
      newDeliveryDate: "",
      newPricePerUnit: "",
      productName: "",
      productDescription: "",
      productPrice: "",
      bids: [],
      fields: [
        { key: "userId", label: "UserID", sortable: true },
        { key: "price", label: "Price", sortable: true },
        { key: "amount", label: "Amount", sortable: true },
        { key: "pricePerUnit", label: "€/Unit", sortable: true },
        { key: "deliveryDate", label: "Delivery Date", sortable: false },
        { key: "timestamp", label: "Timestamp", sortable: true },
      ],
    };
  },
  created: function () {
    this.timer = setInterval(() => {
      if (this.auction.status == "OPEN") {
        this.decreaseTimeLeft();
      }
    }, 1000);
  },
  async mounted() {
    if (this.status === "OPEN" && this.auction.userId != localStorage.getItem("userId")) {
      this.showButtons = true;
    } else {
      this.showButtons = false;
    }
    await this.getProductPicture();
    await this.getProducts();
    await this.getBids();
  },
  methods: {
    onRowClicked(row) {
      if (this.auction.status == "CLOSED" && this.auction.userId == localStorage.getItem("userId")) {
        console.log(row);
        this.$axios.post(this.$apiUrl + "/bid/accept", { bidId: row.id }, this.jwtConfig).then(() => {
          this.modalTitleText = "SUCCESS";
          this.getBids();
          this.triggerModal("Bid accepted!");
        });
      }
    },
    async getProductPicture() {
      this.$axios.post(this.$apiUrl + "/image/getProductPicture", { productId: this.productId }).then((responseImage) => {
        if (responseImage.data.imgData != null) {
          const parsed = JSON.parse(responseImage.data.imgData);
          this.imgBase64 = parsed.imgData;
          this.base64Picture = true;
        } else if (responseImage.data != null) {
          this.imgPath = responseImage.data.imgUrl;
        }
      });
    },
    async getProducts() {
      this.$axios.get(this.$apiUrl + "/product").then((responseProduct) => {
        responseProduct.data.forEach((product) => {
          if (product.id == this.productId) {
            this.productName = product.name;
            this.productDescription = product.description;
            this.productPrice =
              "€ " +
              product.price.toString() +
              " - € " +
              (product.price * this.auction.minAmount).toFixed(2).toString() +
              " (" +
              this.auction.minAmount.toString() +
              "x)";
          }
        });
      });
    },
    async getBids() {
      this.$axios.post(this.$apiUrl + "/bid/findByAuctionId", { auctionId: this.auction.id }).then((responseBids) => {
        responseBids.data.forEach((bid) => {
          this.showBidsTable = true;
          bid.pricePerUnit = "€ " + (bid.price / bid.amount).toFixed(2).toString();
          bid.priceRaw = bid.price;
          bid.price = "€ " + bid.price.toFixed(2).toString();
          const deliveryDate = new Date(bid.deliveryDate);
          const timestamp = new Date(bid.timestamp);
          bid.deliveryDate = `${deliveryDate.getDate()}.${deliveryDate.getMonth() + 1}.${deliveryDate.getFullYear()}`;
          bid.difference = new Date().getTime() - timestamp.getTime();
          if (this.auction.status == "OPEN") {
            bid.timestamp = this.calculateTimeDifference(bid.difference);
          } else {
            bid.timestamp = `${timestamp.getDate()}.${timestamp.getMonth() + 1}.${timestamp.getFullYear()} ${timestamp.getHours()}:${
              timestamp.getMinutes() < 10 ? "0" : ""
            }${timestamp.getMinutes()}`;
          }
          if (bid.userId == localStorage.getItem("userId")) {
            bid._rowVariant = "info";
          }
          if (bid.confirmed == true) {
            bid._rowVariant = "success";
          }
          this.bids.push(bid);
        });
      });
    },
    calculateNewPricePerUnit() {
      this.newPricePerUnit = "€ " + (this.newPrice / this.newAmount).toFixed(2).toString();
      if (this.newPrice > this.maxPriceRaw) {
        this.showErrorMessageNewPrice = true;
      } else {
        this.showErrorMessageNewPrice = false;
      }
      if (this.newAmount < this.minAmount) {
        this.showErrorMessageNewAmount = true;
      } else {
        this.showErrorMessageNewAmount = false;
      }
      if (this.newDeliveryDate < this.endDate) {
        this.showErrorMessageNewDeliveryDate = true;
      } else {
        this.showErrorMessageNewDeliveryDate = false;
      }
    },
    initBid() {
      this.newPrice = this.maxPriceRaw;
      this.bids.forEach((bid) => {
        if (bid.priceRaw < this.newPrice) {
          this.newPrice = bid.priceRaw;
        }
      });
      this.newAmount = this.minAmount;
      this.newPricePerUnit = "€ " + (this.newPrice / this.newAmount).toFixed(2).toString();
      this.newDeliveryDate = this.deliveryDateRaw;
      this.showCreateBid = true;
      this.showButtons = false;
    },
    async decreaseTimeLeft() {
      this.timeLeftRaw = this.timeLeftRaw - 1000;
      this.timeLeft = this.calculateTimeLeft(this.timeLeftRaw);
      this.bids.forEach((bid) => {
        bid.difference = bid.difference + 1000;
        bid.timestamp = this.calculateTimeDifference(bid.difference);
      });
    },
    calculateTimeLeft(timeLeft) {
      const days = Math.floor(timeLeft / (1000 * 60 * 60 * 24));
      const hours = Math.floor((timeLeft % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      const minutes = Math.floor((timeLeft % (1000 * 60 * 60)) / (1000 * 60));
      const seconds = Math.floor((timeLeft % (1000 * 60)) / 1000);
      if (timeLeft < 0) {
        this.showButtons = false;
        return "Auction Ended";
      } else {
        return `${days}d ${hours}h ${minutes}m ${seconds}s`;
      }
    },
    calculateTimeDifference(timeDifference) {
      const days = Math.floor(timeDifference / (1000 * 60 * 60 * 24));
      const hours = Math.floor((timeDifference % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
      const minutes = Math.floor((timeDifference % (1000 * 60 * 60)) / (1000 * 60));
      const seconds = Math.floor((timeDifference % (1000 * 60)) / 1000);
      if (days > 0) {
        return `${days}d ${hours}h ${minutes}m ${seconds}s ago`;
      } else if (hours > 0) {
        return `${hours}h ${minutes}m ${seconds}s ago`;
      } else if (minutes > 0) {
        return `${minutes}m ${seconds}s ago`;
      } else {
        return `${seconds}s ago`;
      }
    },
    triggerModal(modalBody) {
      this.modalBodyText = modalBody;
      this.$refs.modalName.openModal();
    },
    getImgUrl(productPicture) {
      var images = require.context("../assets/", true);
      return images("./" + productPicture);
    },
    createBid() {
      let checkValues = true;
      if (this.newPrice > this.maxPriceRaw) {
        this.showErrorMessageNewPrice = true;
        checkValues = false;
      } else {
        this.showErrorMessageNewPrice = false;
      }
      if (this.newAmount < this.minAmount) {
        this.showErrorMessageNewAmount = true;
        checkValues = false;
      } else {
        this.showErrorMessageNewAmount = false;
      }
      if (this.newDeliveryDate < this.endDate) {
        this.showErrorMessageNewDeliveryDate = true;
        checkValues = false;
      } else {
        this.showErrorMessageNewDeliveryDate = false;
      }
      if (checkValues) {
        const formatDate = this.newDeliveryDate.toISOString();
        this.newDeliveryDate = formatDate.split("T")[0] + " " + formatDate.split("T")[1].split(".")[0];
        this.$axios
          .post(
            this.$apiUrl + "/bid/create",
            {
              auctionId: this.auction.id,
              price: this.newPrice,
              amount: this.newAmount,
              deliveryDate: this.newDeliveryDate.toString(),
            },
            this.jwtConfig
          )
          .then(() => {
            this.showCreateBid = false;
            this.showButtons = true;
            // check if timeleftraw is less than 5 mins
            if (this.timeLeftRaw < 300000) {
              this.timeLeftRaw = 300000;
              this.timeLeft = this.calculateTimeLeft(this.timeLeftRaw);
            }
            this.bids = [];
            this.getBids();
          });
      }
    },
    async uploadImage() {
      const file = document.querySelector("#imageUploadInput").files[0];
      const reader = new FileReader();
      let rawImg;
      reader.onloadend = () => {
        rawImg = reader.result;
        const formData = {
          imgData: rawImg,
        };
        this.$axios.post(this.$apiUrl + "/image/updateProfilePicture", formData, this.jwtConfig).then((response) => {
          const parsed = JSON.parse(response.data.imgData);
          this.imgBase64 = parsed.imgData;
          this.base64Picture = true;
          this.showButtons = true;
          this.showUploadImage = false;
        });
      };
      reader.readAsDataURL(file);
    },
    redirectAfterLogout() {
      setTimeout(() => this.$router.push("/login"), 1500);
    },
    logout() {
      localStorage.removeItem("token");
      localStorage.removeItem("token_expiration_date");
      localStorage.removeItem("userType");
      localStorage.removeItem("userId");
      this.redirectAfterLogout();
    },
  },
};
</script>

<style scoped>
.form-signup {
  width: 100%;
  max-width: 630px;
  padding: 15px;
  margin: auto;
}

#loginForm .custom-control-label {
  margin-left: 7px;
}

h6 {
  color: green;
  margin-top: 20px;
}

label {
  float: left;
  padding-left: 10px;
}

.form-control:disabled {
  background-color: #fff;
  color: #000;
  font-weight: 550;
  border: none;
}

img {
  border-radius: 4%;
  border: 3pt solid dimgrey;
  float: left;
  width: 215px;
  height: 215px;
  object-fit: cover;
  background-color: dimgray;
}

.lowerRow {
  margin-top: 10px;
}

.disabled-input-show {
  margin-bottom: 0px;
}

.button-profile {
  width: 100%;
  background-color: #995c00 !important;
  border: 2pt solid dimgrey;
}

.button-profile-small {
  margin-top: 10px;
  width: auto;
  background-color: #995c00 !important;
  border: 1pt solid dimgrey;
}

.form-file-upload {
  width: 80%;
}

.form-file-upload:hover {
  cursor: pointer;
}
</style>
