import Vue from "vue";
import VueRouter from "vue-router";
import HomeView from "../views/HomeView.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: HomeView,
  },
  {
    path: "/imprint",
    name: "imprint",
    component: () => import(/* webpackChunkName: "imprint" */ "../views/ImprintView.vue"),
  },
  {
    path: "/help",
    name: "help",
    component: () => import(/* webpackChunkName: "imprint" */ "../views/HelpView.vue"),
  },
  {
    path: "/login",
    name: "login",
    component: () => import(/* webpackChunkName: "imprint" */ "../views/LoginView.vue"),
  },
  {
    path: "/register",
    name: "register",
    component: () => import(/* webpackChunkName: "imprint" */ "../views/RegisterView.vue"),
  },
  {
    path: "/products",
    name: "products",
    component: () => import(/* webpackChunkName: "imprint" */ "../views/ProductView.vue"),
  },
  {
    path: "/modal",
    name: "modal",
    component: () => import(/* webpackChunkName: "imprint" */ "../views/ModalView.vue"),
  },
  {
    path: "/profile",
    name: "profile",
    component: () => import(/* webpackChunkName: "imprint" */ "../views/ProfileView.vue"),
  },
  {
    path: "/users",
    name: "users",
    component: () => import(/* webpackChunkName: "imprint" */ "../views/UsersView.vue"),
  },
  {
    path: "/auction:auction",
    name: "auction",
    component: () => import(/* webpackChunkName: "imprint" */ "../views/AuctionDetailView.vue"),
  }
];

const router = new VueRouter({
  routes,
});

export default router;
