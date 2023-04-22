import { createApp } from "vue";
import { createPinia } from "pinia";
import BootstrapVue from "bootstrap-vue-next"
import "@coreui/coreui/dist/css/coreui.min.css"
import VueDatePicker from "@vuepic/vue-datepicker"
import '@vuepic/vue-datepicker/dist/main.css'



import App from "./App.vue";
import router from "./router";

import "./assets/main.css";

const app = createApp(App);
app.component('VueDatePicker', VueDatePicker)
app.use(BootstrapVue)


app.use(createPinia());
app.use(router);

app.mount("#app");
