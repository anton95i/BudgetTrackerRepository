import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue/dist/bootstrap-vue.css";

import BootstrapVue, { IconsPlugin } from "bootstrap-vue";
import Vue from "vue";
import App from "./App.vue";
import router from "./router";

import axios from "axios";
Vue.prototype.$axios = axios;

Vue.prototype.$apiUrl = "http://localhost:8081";

Vue.config.productionTip = false;

Vue.use(BootstrapVue);
Vue.use(IconsPlugin);

new Vue({
  router,
  render: (h) => h(App),
  watch: {
    $route: function () {
      if(localStorage.getItem("token_expiration_date") != null) {
        let tokenExpiration = localStorage.getItem("token_expiration_date");
        let now = Date.now();
        if (now > tokenExpiration) {
          localStorage.removeItem("token");
          localStorage.removeItem("token_expiration_date");
          localStorage.removeItem("userType");
          localStorage.removeItem("userId");
          this.$router.push("/login");
        }
      } else {
        localStorage.removeItem("token");
        localStorage.removeItem("userId");
        localStorage.removeItem("userType");
      }
    },
  },
}).$mount("#app");

import "bootstrap/dist/js/bootstrap.js";
import "./assets/css/stylesheet.css";
import "./assets/css/stylesheet-mobile.css";
import "./assets/css/stylesheet-modal.css";
import "./assets/css/stylesheet-loading.css";
