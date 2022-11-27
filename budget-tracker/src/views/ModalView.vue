<template>
  <div id="contentContainer" class="container rounded-lg mt-3 shadow-lg p-3 mb-5 bg-white rounded">
    <b-container fluid>
      <b-row>
        <b-col lg="4" class="my-1">
          <b-form-input id="modal-title-text" v-model="modalTitleText" type="search" placeholder="Input Modal Title"></b-form-input>
        </b-col>
        <b-col lg="8" class="my-1">
          <b-form-input id="modal-body-text" v-model="modalBodyText" type="search" placeholder="Input Modal Body"></b-form-input>
        </b-col>
      </b-row>
      <b-row>
        <b-col lg="12" class="my-1">
          <button class="btn btn-primary mx-auto" @click="$refs.modalName.openModal()">Open modal</button>
        </b-col>
      </b-row>
    </b-container>
    <ModalMain :title="modalTitleText" :body="modalBodyText" ref="modalName" />
  </div>
</template>

<script>
import ModalMain from "../components/modal-main.vue";
export default {
  name: "HomeView",
  components: {
    ModalMain,
  },
  data() {
    return {
      modalTitleText: "",
      modalBodyText: "",
    };
  },
};
</script>
