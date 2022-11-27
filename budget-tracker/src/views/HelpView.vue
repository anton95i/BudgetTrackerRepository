<template>
  <div id="contentContainer" class="container rounded-lg mt-3 shadow-lg p-3 mb-5 bg-white rounded">
    <h2>{{ Page_title }}</h2>
    <br />
    <div class="accordion" role="tablist">
      <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block v-b-toggle.accordion-1 variant="info">{{ Accordion1_title }}</b-button>
        </b-card-header>
        <b-collapse id="accordion-1" visible accordion="my-accordion" role="tabpanel">
          <b-card-body>
            <b-card-text>{{ Accordion1_text }}</b-card-text>
          </b-card-body>
        </b-collapse>
      </b-card>
      <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block v-b-toggle.accordion-2 variant="info">{{ Accordion2_title }}</b-button>
        </b-card-header>
        <b-collapse id="accordion-2" accordion="my-accordion" role="tabpanel">
          <b-card-body>
            <b-card-text>{{ Accordion2_text }}</b-card-text>
          </b-card-body>
        </b-collapse>
      </b-card>
      <b-card no-body class="mb-1">
        <b-card-header header-tag="header" class="p-1" role="tab">
          <b-button block v-b-toggle.accordion-3 variant="info">{{ Accordion3_title }}</b-button>
        </b-card-header>
        <b-collapse id="accordion-3" accordion="my-accordion" role="tabpanel">
          <b-card-body>
            <b-card-text>{{ Accordion3_text }}</b-card-text>
          </b-card-body>
        </b-collapse>
      </b-card>
    </div>
  </div>
</template>

<script>
export default {
  name: "HelpView",
  data() {
    return {
      Page_title: "Help/FAQ",
      Accordion1_title: "How to use the app?",
      Accordion1_text: `This is a simple app to help you to manage your expenses. 
        You can add, edit and delete your expenses. 
        You can also filter your expenses by date and category. 
        You can also see your expenses in a chart.`,
      Accordion2_title: "How to add an expense?",
      Accordion2_text: `To add an expense, click on the "Add Expense" button. 
        Then, fill the form with the expense details.`,
      Accordion3_title: "How to edit an expense?",
      Accordion3_text: `To edit an expense, click on the "Edit" button. 
        Then, edit the form with the expense details.`,
    };
  },
};
</script>

<style>
.btn-info {
  background-color: transparent !important;
  border: none;
  border-radius: 0px;
  text-decoration: none;
  background: linear-gradient(to right, rgba(100, 200, 200, 1), rgba(100, 200, 200, 1)),
    linear-gradient(to right, rgba(255, 0, 0, 1), rgba(255, 0, 180, 1), rgba(0, 100, 200, 1));
  background-size: 100% 3px, 0 3px;
  background-position: 100% 100%, 0 100%;
  background-repeat: no-repeat;
  transition: background-size 400ms;
}

.btn-info:hover {
  background-size: 0 3px, 100% 3px;
}
</style>
