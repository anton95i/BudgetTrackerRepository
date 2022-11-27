<template>
  <div id="contentContainer" class="signupcontentContainer container rounded-lg mt-3 shadow-lg p-3 mb-5 bg-white rounded">
    <h4 class="text-center">Register</h4>
    <br />
    <div class="form-signin">
      <b-form id="signupForm">
        <b-row>
          <b-col>
            <b-form-input type="email" class="form-control" id="email" name="email" placeholder="E-Mail" autofocus />
          </b-col>
          <b-col>
            <b-form-input type="text" class="form-control" id="username" name="username" placeholder="Username" />
          </b-col>
        </b-row>
        <br />
        <b-row>
          <b-col>
            <b-form-input type="text" class="form-control" id="firstname" name="firstname" placeholder="Firstname" />
          </b-col>
          <b-col>
            <b-form-input type="text" class="form-control" id="lastname" name="lastname" placeholder="Lastname" />
          </b-col>
        </b-row>
        <br />
        <b-form-input type="password" class="form-control" id="password" name="password" placeholder="Password" /><br />
        <b-form-input type="password" class="form-control" id="password2" name="password2" placeholder="Repeat passwort" /><br />
        <b-button class="btn btn-lg btg-dark btn-block" type="submit" name="login">Submit</b-button>
      </b-form>
      <br />
      <label>Already have an account? <router-link to="/login">Login Here!</router-link></label>
    </div>
  </div>
</template>

<script>
export default {
  name: "RegisterView",
};
</script>

<style>
.form-signup {
  width: 100%;
  max-width: 630px;
  padding: 15px;
  margin: auto;
}

#loginForm .custom-control-label {
  margin-left: 7px;
}
</style>
