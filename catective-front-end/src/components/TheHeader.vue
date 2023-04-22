<template>
  <CHeader :style="vars" position="fixed" class="the-header">
    <CContainer fluid>
      <CHeaderBrand class="the-header-brand" href="#">Catective</CHeaderBrand>
      <CHeaderToggler @click="visible = !visible" />
      <CCollapse class="header-collapse" :visible="visible">
        <CHeaderNav class="the-nav">
          <CNavItem>
            <CNavLink href="#"> Home </CNavLink>
          </CNavItem>
          <CNavItem>
            <CNavLink href="#">Why Cats?</CNavLink>
          </CNavItem>
          <CNavItem class="the-nav-button">
            <CButton :style="vars">Download app</CButton>
          </CNavItem>
        </CHeaderNav>
      </CCollapse>
    </CContainer>
  </CHeader>
</template>

<script setup lang="ts">
import {
  CNavItem,
  CHeader,
  CHeaderNav,
  CNavLink,
  CHeaderBrand,
  CCollapse,
  CContainer,
  CHeaderToggler,
  CButton,
} from "@coreui/vue";

const visible = true;
const vars = {
  "--cui-header-bg": "rgb(12, 19, 54)",
  "--cui-header-color": "white",
  "--cui-header-brand-color": "white",
  "--cui-btn-bg": "rgb(233, 138, 144)",
  "--cui-btn-border-color": "transparent",
  "--cui-btn-color": "white",
  "--cui-header-nav-link-padding-x": "30px",
  "--cui-header-padding-x": "50px",
};
</script>

<style scoped>
.the-header .the-header-brand {
  padding-left: 4em;
}

.the-nav-button {
  padding-left: 30px;
}
</style>
