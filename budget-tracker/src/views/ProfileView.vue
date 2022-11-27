<template>
  <div id="contentContainer" class="signupcontentContainer container rounded-lg mt-3 shadow-lg p-3 mb-5 bg-white rounded">
    <h6 v-if="showSuccess">Successfully...</h6>
    <div>
      <b-row>
        <b-col cols="4">
          <img @click="uploadImageInit" v-if="base64Picture === false" alt="Profile Picture" :src="getImgUrl(imgPath)" />
          <img @click="uploadImageInit" v-if="base64Picture === true" alt="Profile Picture" :src="imgBase64" />
        </b-col>
        <b-col>
          <b-row class="lowerRow">
            <b-col>
              <label for="firtname" class="disabled-input-show">Name:</label>
              <b-form-input v-model="name" type="text" class="form-control" id="name" name="name" placeholder="Name" disabled />
            </b-col>
          </b-row>
          <b-row class="lowerRow">
            <b-col>
              <label for="email" label-align="left" class="disabled-input-show">E-Mail:</label>
              <b-form-input v-model="email" type="email" class="form-control" id="email" name="email" placeholder="Email" disabled />
            </b-col>
          </b-row>
          <b-row class="lowerRow">
            <b-col>
              <label for="status" label-align="left" class="disabled-input-show">Usertype:</label>
              <b-form-input v-model="userType" type="text" class="form-control" id="usertype" name="usertype" placeholder="Usertype" disabled />
            </b-col>
          </b-row>
        </b-col>
      </b-row>
      <br />
      <b-row>
        <b-col>
          <b-button v-if="showButtons === true" class="button-profile btn btn-lg btg-dark btn-block" type="submit" name="login" @click="editDataInit">Edit Data</b-button>
        </b-col>
      </b-row>
      <b-row>
        <b-col>
          <b-button
            style="margin-top: 8px"
            v-if="showButtons === true"
            class="button-profile btn btn-lg btg-dark btn-block"
            type="submit"
            name="login"
            @click="editPassword"
            >Change Password</b-button
          >
        </b-col>
      </b-row>
      <b-form id="changePassword" v-if="showChangePassword === true">
        <label for="oldpassword">Old password</label>
        <b-form-input type="password" class="form-control" id="oldpassword" name="oldpassword" placeholder="Old password" autofocus /><br />
        <label for="newpassword">New password</label>
        <b-form-input type="password" class="form-control" id="password" name="password" placeholder="New password" /><br />
        <label for="newpassword2">Repeat new password</label>
        <b-form-input
          type="password"
          class="form-control"
          id="password2"
          name="password2"
          placeholder="Repeat new password"
          v-on:input="checkNewPasswordMatch()"
          v-on:keyup.enter="changePassword()"
        />
        <label v-if="showErrorMessageNewPassword === true" style="color: red" for="newpassword2">Passwords do not match!</label>
        <br />
        <b-button @click="changePassword()" class="btn btn-lg btg-dark btn-block" name="login">Submit</b-button>
      </b-form>

      <b-form id="editData" v-if="showEditData === true">
        <label for="email">E-Mail</label>
        <b-form-input v-model="newEmail" type="email" class="form-control" id="email" name="email" placeholder="E-Mail" v-on:keyup.enter="editData()" /><br />

        <label for="firstname">Firstname</label>
        <b-form-input
          v-model="newFirstName"
          type="text"
          class="form-control"
          id="firstname"
          name="firstname"
          placeholder="Firstname"
          v-on:keyup.enter="editData()"
        /><br />

        <label for="lastname">Lastname</label>
        <b-form-input v-model="newLastName" type="text" class="form-control" id="lastname" name="lastname" placeholder="Lastname" v-on:keyup.enter="editData()" /><br />

        <b-button @click="editData()" class="btn btn-lg btg-dark btn-block" name="login">Submit</b-button>
      </b-form>

      <b-form id="changePassword" v-if="showUploadImage === true">
        <b-col>
          <b-form-file @change="uploadImage()" v-model="newImage" id="imageUploadInput" class="form-file-upload" accept=".jpg, .png" placeholder="Choose an image..." />
        </b-col>
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
      jwtConfig: {
        headers: {
          Authorization: "Bearer " + localStorage.getItem("token"),
        },
      },
      modalTitleText: "ERROR",
      modalBodyText: "",
      imgPath: "default_profile_picture.jpg",
      imgBase64: "",
      showSuccess: false,
      showButtons: true,
      showChangePassword: false,
      showUploadImage: false,
      showEditData: false,
      showErrorMessageNewPassword: false,
      base64Picture: false,
      newImage: null,
      user: null,
      email: "",
      firstName: "",
      lastName: "",
      userType: "",
      name: "",
      newFirstName: "",
      newLastName: "",
      newEmail: "",
    };
  },
  async mounted() {
    // eslint-disable-next-line no-unused-vars
    const responseUser = await this.$axios.get(this.$apiUrl + "/auth/getUser", this.jwtConfig).then((responseUser) => {
      this.user = responseUser.data;
      this.email = this.user.email;
      this.firstName = this.user.firstName;
      this.lastName = this.user.lastName;
      this.name = this.user.firstName + " " + this.user.lastName;
      if (this.user.admin == true) {
        this.userType = "ADMIN";
      } else {
        this.userType = "USER";
      }
    });
    // eslint-disable-next-line no-unused-vars
    const responseImage = await this.$axios.get(this.$apiUrl + "/image/getProfilePicture", this.jwtConfig).then((responseImage) => {
      if (responseImage.data.imgData != null) {
        const parsed = JSON.parse(responseImage.data.imgData);
        this.imgBase64 = parsed.imgData;
        this.base64Picture = true;
      } else if (responseImage.data != null) {
        this.imgPath = responseImage.data.imgUrl;
      }
    });
  },
  methods: {
    redirect() {
      this.showChangePassword = false;
      this.showUploadImage = false;
      this.showEditData = false;
      this.showButtons = true;
      setTimeout(() => (this.showSuccess = false), 1500);
    },
    triggerModal(modalBody) {
      this.modalBodyText = modalBody;
      this.$refs.modalName.openModal();
    },
    getImgUrl(profilePicture) {
      var images = require.context("../assets/", true);
      return images("./" + profilePicture);
    },
    editPassword() {
      this.showChangePassword = true;
      this.showButtons = false;
      this.showUploadImage = false;
      this.showEditData = false;
    },
    editData() {
      if (this.newEmail == "") {
        this.newEmail = this.email;
      }
      if (this.newFirstName == "") {
        this.newFirstName = this.firstName;
      }
      if (this.newLastName == "") {
        this.newLastName = this.lastName;
      }
      this.$axios
        .post(
          this.$apiUrl + "/auth/updateUser",
          {
            email: this.newEmail,
            firstName: this.newFirstName,
            lastName: this.newLastName,
          },
          this.jwtConfig
        )
        .then((response) => {
          if (response.status === 200) {
            if(this.email != this.newEmail){
              this.logout();
            }
            this.email = this.newEmail;
            this.firstName = this.newFirstName;
            this.lastName = this.newLastName;
            this.name = this.newFirstName + " " + this.newLastName;
            this.showSuccess = true;
            this.redirect();
          } else {
            this.triggerModal("Something went wrong");
            this.redirect();
          }
        })
        .catch((error) => {
          this.triggerModal(error.response.status);
          this.redirect();
        });
    },
    async changePassword() {
      const oldPassword = document.getElementById("oldpassword").value;
      const newPassword = document.getElementById("password").value;
      const newPassword2 = document.getElementById("password2").value;
      if (newPassword === newPassword2) {
        this.$axios
          .post(
            this.$apiUrl + "/auth/updatePassword",
            {
              oldPassword: oldPassword,
              newPassword: newPassword,
            },
            this.jwtConfig
          )
          .then((response) => {
            if (response.status === 200) {
              this.showSuccess = true;
              this.redirect();
            } else {
              this.triggerModal("Something went wrong");
            }
          })
          .catch((error) => {
            this.redirect();
            this.triggerModal("Something went wrong");
            console.log(error);
          });
      } else {
        this.triggerModal("Passwords do not match");
      }
    },
    checkNewPasswordMatch() {
      const newPassword = document.getElementById("password").value;
      const newPassword2 = document.getElementById("password2").value;
      if (newPassword === newPassword2) {
        this.showErrorMessageNewPassword = false;
      } else {
        this.showErrorMessageNewPassword = true;
      }
    },
    uploadImageInit() {
      this.showUploadImage = true;
      this.showButtons = false;
      this.showChangePassword = false;
      this.showEditData = false;
    },
    editDataInit() {
      this.newEmail = this.email;
      this.newFirstName = this.firstName;
      this.newLastName = this.lastName;
      this.showEditData = true;
      this.showButtons = false;
      this.showChangePassword = false;
      this.showUploadImage = false;
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
      setTimeout(() => (this.$router.push("/login")), 1500);
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

img:hover {
  opacity: 0.7;
  cursor: pointer;
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
