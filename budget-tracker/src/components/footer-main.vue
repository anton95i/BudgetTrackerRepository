<template>
  <footer class="text-center text-white fixed-bottom" style="background-color: #f1f1f1">
    <div class="container pt-1">
      <section>
        <nav>
          <p class="footer-text d-flex justify-content-center">
            <span><router-link to="/imprint">Imprint</router-link></span>
            <span><router-link to="/help">Help</router-link></span>
          </p>
        </nav>
      </section>
    </div>
    <div class="text-center text-dark p-3" style="background-color: rgba(0, 0, 0, 0.2)"> Alexander Goldinger, Anton Steiner, Branislav Vasic & Morkoc Can</div>
  </footer>
</template>

<script>
export default {
  name: "FooterMain",
};
</script>

<style>
.footer-text a {
  color: black;
  text-decoration: none;
  font-weight: 500;
}

.footer-text a:hover {
  color: grey;
}

.footer-text {
  margin-bottom: 5px;
}
</style>
