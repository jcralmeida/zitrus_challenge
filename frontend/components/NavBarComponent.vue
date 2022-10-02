<template>
  <b-navbar class="border rounded-pill" variant="primary">
    <b-navbar-nav>
      <b-nav-item
      >
        <NuxtLink
          class="font-weight-bolder text-white-50 text-decoration-none"
          to="listarMovimentacao">
          Listar Movimentação de Estoque
        </NuxtLink>
      </b-nav-item
      >
      <b-nav-item
      >
        <NuxtLink
          class="font-weight-bolder text-white-50 text-decoration-none"
          to="adicionarProduto">
          Adicionar Produto
        </NuxtLink>
      </b-nav-item
      >
      <b-nav-item>
        <NuxtLink class="font-weight-bolder text-white-50 text-decoration-none" to="/">
          Listar Produtos
        </NuxtLink>
      </b-nav-item>
    </b-navbar-nav>
  </b-navbar>
</template>

<script>
export default {
  name: "NavBarComponent"
}
</script>

<style scoped>

</style>
