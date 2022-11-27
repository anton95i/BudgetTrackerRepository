<template>
  <div id="contentContainer" class="container rounded-lg mt-3 shadow-lg p-3 mb-5 bg-white rounded">
    <br />
    <h2>Products:</h2>
    <br />
    <div v-if="showProducts == false">
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
    <b-container fluid v-if="showProducts == true">
      <!--<p class="mt-3">Current Page: {{ currentPage }}</p>-->
      <b-row>
        <b-col lg="6" class="my-1">
          <b-form-group>
            <b-input-group size="sm">
              <b-form-input id="filter-input" v-model="filter" type="search" placeholder="Type to Search"></b-form-input>

              <b-input-group-append>
                <b-button style="border: none !important" :disabled="!filter" @click="filter = ''">Clear</b-button>
              </b-input-group-append>
            </b-input-group>
          </b-form-group>
        </b-col>
        <b-col lg="6" class="my-1">
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
        :items="products"
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
</template>

<script>
export default {
  name: "ProductView",
  props: {
    msg: String,
  },
  data() {
    return {
      showProducts: false,
      perPage: 12,
      currentPage: 1,
      sortBy: "id",
      sortDesc: false,
      filter: null,
      filterOn: [],
      options: [
        { text: "Category", value: "category" },
        { text: "Auction Name", value: "auction_name" },
        { text: "Seller", value: "seller" },
      ],
      fields: [
        { key: "id", label: "ID", sortable: true },
        { key: "name", label: "Name", sortable: true },
        { key: "description", label: "Description", sortable: true },
        { key: "price", label: "Price", sortable: true },
      ],
      products: [],
    };
  },
  async mounted() {
    // eslint-disable-next-line no-unused-vars
    const responseProducts = await this.$axios.get(this.$apiUrl + "/product").then((responseProducts) => {
      this.products = responseProducts.data;
      this.products.forEach((product) => {
        if(product.description.length > 70) {
          product.description = product.description.substring(0, 70) + "...";
        }
        product.price = "€ " + product.price;
      });
    });
    this.showProducts = true;
  },
  computed: {
    rows() {
      return this.products.length;
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
</style>
