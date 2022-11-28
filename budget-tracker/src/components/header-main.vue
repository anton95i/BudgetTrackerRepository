<template>
  <b-navbar class="fixed-top" toggleable="lg" type="dark" variant="dark">
    <b-link class="navbar-brand" to="/" />
    <b-navbar-nav class="me-auto">
      <b-nav-item class="text-typewriter-parent" to="/"><p class="text animation-typewriter">CASH CONNAISSEUR</p></b-nav-item>
    </b-navbar-nav>
    <b-navbar-toggle class="navbar-toggle-button this-is-my-own-class" target="nav-collapse"></b-navbar-toggle>
    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav v-if="showDefault == 'default'" class="ms-auto">
        <b-nav-item class="underlined" to="/modal">Default</b-nav-item>
        <b-nav-item class="underlined" to="/login">Login</b-nav-item>
        <b-nav-item class="last-item underlined" to="/register">Register</b-nav-item>
      </b-navbar-nav>
      <b-navbar-nav v-if="showDefault === 'user'" class="ms-auto">
        <b-nav-item class="underlined" to="/modal">User</b-nav-item>
        <b-nav-item class="underlined" to="/statistic">Statistic</b-nav-item>
        <b-nav-item class="underlined" to="/profile">Profile</b-nav-item>
        <b-nav-item class="last-item underlined" @click="logout">Logout</b-nav-item>
      </b-navbar-nav>
      <b-navbar-nav v-if="showDefault === 'admin'" class="ms-auto">
        <b-nav-item class="underlined" to="/modal">Admin</b-nav-item>
        <b-nav-item class="underlined" to="/statistic">Statistic</b-nav-item>
        <b-nav-item class="underlined" to="/users">Users</b-nav-item>
        <b-nav-item class="underlined" to="/profile">Profile</b-nav-item>
        <b-nav-item class="last-item underlined" @click="logout">Logout</b-nav-item>
      </b-navbar-nav>
    </b-collapse>
  </b-navbar>
</template>

<script>
export default {
  name: "HeaderMain",
  
  data() {
    return {
      showDefault: "default",
    };
  },
  methods: {
    redirectAfterLogout() {
      setTimeout(() => (this.$router.push("/login")), 1200);
    },
    logout() {
      localStorage.removeItem("token");
      localStorage.removeItem("token_expiration_date");
      localStorage.removeItem("userType");
      localStorage.removeItem("userId");
      this.showDefault = "default";
      document.getElementById("contentContainer").innerHTML = "";
      document.getElementById("contentContainer").innerHTML = "<h3>Logging out...</h3>";
      
      this.redirectAfterLogout();
    },
    checkUserType() {
      if(localStorage.getItem("userType") == null) {
        this.showDefault = "default";
      } else if(localStorage.getItem("userType") === "user") {
        this.showDefault = "user";
      } else if(localStorage.getItem("userType") === "admin") {
        this.showDefault = "admin";
      }
    }
  },
  watch: {
    $route() {
      this.checkUserType();
    },
  },
  mounted() {
    this.checkUserType();
  }
};
</script>

<style>
h3 {
  text-align: center;
  margin-top: 20px;
  margin-bottom: 20px;
}
</style>