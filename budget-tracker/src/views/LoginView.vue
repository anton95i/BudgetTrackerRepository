<template>
  <div id="contentContainer" class="logincontentContainer container rounded-lg mt-3 shadow-lg p-3 mb-5 bg-white rounded">
    <h4 class="text-center">Login</h4>
    <h6 v-if="showSuccess">Login successfully...</h6>
    <div class="form-signin" v-if="showForm">
      <!-- <b-form id="loginForm" @submit="login"> -->
      <b-form id="loginForm" v-on:submit.prevent="login">
        <b-form-input type="text" class="form-control" v-model="username" name="username" placeholder="Username" autofocus /><br />
        <b-form-input type="password" class="form-control" v-model="password" name="password" placeholder="Password" /><br />
        <b-form-checkbox type="checkbox" v-model="safeit" name="safeit" value="true" unchecked-value="false"
          >Stay logged in!
          <b-button class="btn btn-lg btg-dark btn-block" type="submit" name="login">Submit</b-button>
        </b-form-checkbox>
      </b-form>
      <br />
      <label>No Account yet? <router-link to="/register">Register Here!</router-link></label>
    </div>
    <ModalMain :title="modalTitleText" :body="modalBodyText" ref="modalName" />
  </div>
</template>

<script>
import ModalMain from "../components/modal-main.vue";
export default {
  name: "LoginView",
  components: {
    ModalMain,
  },
  data() {
    return {
      modalTitleText: "ERROR",
      modalBodyText: "",
      showSuccess: false,
      showForm: true,
      timer: null,
      username: "",
      password: "",
      safeit: false,
    };
  },
  methods: {
    triggerModal(modalBody) {
      this.modalBodyText = modalBody;
      this.$refs.modalName.openModal();
    },
    redirect() {
      setTimeout(() => this.$router.push("/profile"), 1000);
    },
    login() {
      this.$axios
        .post(this.$apiUrl + "/auth/login", {
          email: this.username,
          password: this.password,
          safeit: this.safeit,
        })
        .then((response) => {
          localStorage.setItem("token", response.data.token);
          localStorage.setItem("userType", response.data.userType);
          localStorage.setItem("userId", response.data.userId);
          localStorage.setItem("token_expiration_date", Date.now() + 86400000);
          //localStorage.setItem("token_expiration_date", Date.now() + 10000);
          this.showForm = false;
          this.showSuccess = true;
          this.redirect();
        })
        .catch((error) => {
          this.triggerModal("Login failed!");
          console.log(error);
        });
    },
  }
};
</script>

<style scoped>
.form-signin {
  width: 100%;
  max-width: 330px;
  padding: 15px;
  margin: auto;
}

#loginForm .custom-control-label {
  margin-left: 7px;
}
</style>

<style scoped>
h6 {
  color: green;
  margin-top: 20px;
}
</style>
