<template>
    <b-navbar type="dark fixed-top" variant="dark">
        <b-link class="navbar-brand" to="/"/>
      <b-navbar-nav class="me-auto">
        <b-nav-item class="text-typewriter-parent" to="/"><p class="text animation-typewriter">CASH CONNAISSEUR</p></b-nav-item>
        <b-nav-item to="/about">About</b-nav-item>
      </b-navbar-nav>
      <b-navbar-nav class="ms-auto">
        <b-nav-item to="">Login</b-nav-item>
        <b-nav-item class="last-item" to="">Login</b-nav-item>
      </b-navbar-nav>
    </b-navbar>
</template>

<script>
export default {
    name: 'HeaderMain'
}
</script>

<style>
@import url(https://fonts.googleapis.com/css?family=Anonymous+Pro);

.navbar-brand {
    background-image: url(../assets/logo.png);
    background-size: 30px 30px;
    background-repeat: no-repeat;
    background-position: center;
    width: 30px;
    height: 30px;
    display: inline-block;
    margin-right: 10px;
    margin-left: 15px;
}

.ms-auto .last-item {
    margin-right: 15px;
}

.text {
    font-family: "Anonymous Pro", monospace;
    position: relative;
    border-right: 2px solid transparent;
    text-align: center;
    white-space: nowrap;
    overflow: hidden;
    margin: 0 auto;
}

.animation-typewriter {
  animation: typewriter 3s steps(16) 1s 1 normal both,
    blinkTextCursor 500ms steps(44) 9 normal;
}
@keyframes typewriter {
  from {
    width: 0;
  }
  to {
    width: 142px;
  }
}
@keyframes blinkTextCursor {
  from {
    border-right-color: hsl(0, 0%, 80%);
  }
  to {
    border-right-color: transparent;
  }
}
</style>