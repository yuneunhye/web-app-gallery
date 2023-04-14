import { createRouter, createWebHistory } from 'vue-router';
import Home from '@/pages/Home';
import Login from '@/pages/Login';
import Cart from "@/pages/Cart";
import Order from "@/pages/Order";
import Orders from "@/pages/Orders";


const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path:'/login',
    name:'login',
    component:Login
  },
  { 
    path: '/cart', 
    component: Cart 
  },
  { 
    path: '/order', 
    component: Order 
  },
  { 
    path: '/orders', 
    component: Orders 
  }

 
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router;
