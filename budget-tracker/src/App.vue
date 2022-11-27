<template>
  <div id="app">
    <HeaderMain />
    <router-view />
    <FooterMain />
  </div>
</template>

<script>
import HeaderMain from "./components/header-main.vue";
import FooterMain from "./components/footer-main.vue";
export default {
  name: "App",
  components: {
    HeaderMain,
    FooterMain,
  },
  methods: {
    checkToken() {
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
    }
  },
  mounted() {
    this.checkToken();
  },
};
</script>
