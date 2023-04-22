<template>
  <div style="height: 100vh">
    <CContainer fluid style="margin-top: 40px">
      <CCard :style="cardStyle" class="mx-auto">
        <CCardBody>
          <CForm>
            <CRow class="the-row">
              <CCol class="ccol col-sm-6">
                <CFormInput
                  type="text"
                  label="Cat Name"
                  placeholder="Your cat's name here"
                  v-model="name"
                  style="background-color: #16225e"
                />
              </CCol>
              <CCol xs="auto" class="ccol col-sm-6">
                <label for="date-lost">Date</label>
                <VueDatePicker
                  name="date-lost"
                  style="margin-top: 8px"
                  placeholder="Date"
                  v-model="date"
                  :dark="true"
                ></VueDatePicker>
              </CCol>
            </CRow>
            <CRow class="mt-4 the-row">
              <CCol class="ccol col-sm-6">
                <CFormTextarea
                  style="background-color: #16225e"
                  label="Cat Description"
                  v-model="desc"
                  placeholder="Your cat's description here"
                ></CFormTextarea>
              </CCol>
              <CCol class="ccol col-sm-6">
                <CFormTextarea
                  style="background-color: #16225e"
                  label="Location"
                  v-model="location"
                  placeholder="Cat's location"
                ></CFormTextarea>
              </CCol>
            </CRow>
            <CRow
              class="mt-5 the-row d-flex align-items-center justify-content-center text-center"
            >
              <CFormInput
                style="
                  background-color: #16225e;
                  width: 38em;
                  color: whitesmoke;
                "
                type="file"
                id="inputGroupFile01"
                label="Cat's Picture"
                accept="image/*"
                @change="onFileInputChange($event)"
              />
            </CRow>
            <CRow class="mt-5 d-flex align-items-center justify-content-center">
              <CButton :style="buttonStyle">Add Cat</CButton>
            </CRow>
          </CForm>
        </CCardBody>
      </CCard>
    </CContainer>
  </div>
</template>

<script setup lang="ts">
import {
  CRow,
  CContainer,
  CCol,
  CCard,
  CCardBody,
  CForm,
  CFormInput,
  CFormTextarea,
  CButton,
} from "@coreui/vue";
import VueDatePicker from "@vuepic/vue-datepicker";
import { ref } from "vue";

const name = ref("");
const date = ref();
const desc = ref("");
const location = ref("");
const file = ref<File | null>();

const cardStyle = {
  "--cui-card-bg": "#16225e",
  "--cui-card-color": "white",
  width: "80em",
};

const buttonStyle = {
  "--cui-btn-bg": "rgb(241, 137, 206)",
  "--cui-btn-color": "white",
  width: "20rem",
};

const onFileInputChange = ($event: Event) => {
  const target = $event.target as HTMLInputElement;
  if (target && target.files) {
    file.value = target.files[0];
  }
};
</script>

<style scoped>
.the-row .ccol {
  text-align: center;
}

.dp__theme_dark {
  --dp-background-color: #16225e;
  --dp-border-color: white;
}
</style>
