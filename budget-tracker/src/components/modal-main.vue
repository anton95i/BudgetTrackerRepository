<template>
  <transition name="fade">
    <div class="modal" v-if="show">
      <div class="modal__backdrop" @click="closeModal()" />
      <div class="modal__dialog">
        <div class="modal__header">
          <h3>{{ checkTitleProp(title) }}</h3>
          <button type="button" class="modal__close button-modal-close" @click="closeModal()">
            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 352 512">
              <path
                fill="currentColor"
                d="M242.72 256l100.07-100.07c12.28-12.28 12.28-32.19 0-44.48l-22.24-22.24c-12.28-12.28-32.19-12.28-44.48 0L176 189.28 75.93 89.21c-12.28-12.28-32.19-12.28-44.48 0L9.21 111.45c-12.28 12.28-12.28 32.19 0 44.48L109.28 256 9.21 356.07c-12.28 12.28-12.28 32.19 0 44.48l22.24 22.24c12.28 12.28 32.2 12.28 44.48 0L176 322.72l100.07 100.07c12.28 12.28 32.2 12.28 44.48 0l22.24-22.24c12.28-12.28 12.28-32.19 0-44.48L242.72 256z"
              ></path>
            </svg>
          </button>
        </div>
        <div class="modal__body">
          <h4>{{ checkBodyProp(body) }}</h4>
        </div>
        <!---
        <div class="modal__footer">
          <div class="d-flex align-items-center justify-content-between">
            <button class="btn btn--secondary" @click="$refs.modalName.closeModal()">Cancel</button>
            <button class="btn btn--primary" @click="$refs.modalName.closeModal()">Save</button>
          </div>
        </div> 
        -->
      </div>
    </div>
  </transition>
</template>

<script>
export default {
  name: "ModalMain",
  data() {
    return {
      show: false,
    };
  },
  props: {
    title: {
      type: String,
      default: "Modal Title",
    },
    body: {
      type: String,
      default: "Modal Body",
    },
  },
  methods: {
    closeModal() {
      this.show = false;
      document.querySelector("body").classList.remove("overflow-hidden");
    },
    openModal() {
      this.show = true;
      document.querySelector("body").classList.add("overflow-hidden");
    },
    checkTitleProp(str) {
      if (str === "") {
        return "Modal Title";
      } else {
        return str;
      }
    },
    checkBodyProp(str) {
      if (str === "") {
        return "Modal Body";
      } else {
        return str;
      }
    },
  },
};
</script>
