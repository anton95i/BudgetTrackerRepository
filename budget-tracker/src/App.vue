<template>
  <div id="app">
    <HeaderMain />
    <router-view/>
    <FooterMain />
  </div>
</template>

<script>
import HeaderMain from './components/header-main.vue'
import FooterMain from './components/footer-main.vue'
export default {
  name: 'App',
  components: {
    HeaderMain,
    FooterMain
  }
}
</script>

<style>
body {
  margin-top: 85px;
  margin-bottom: 140px;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 5px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
  padding: 5px;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
