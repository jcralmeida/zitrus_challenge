<template>
  <b-modal
    v-model="deleteModalShow"
    hide-footer
    @hide="$emit('hideDeleteModal', $event)"
    title="Apagar Produto"
  >
    <p class="my-4">Você quer realmente apagar esse Produto?</p>
    <b-button
      class="mt-2"
      variant="danger"
      @click="$emit('hideDeleteModal', $event)"
    >
      Não
    </b-button>
    <b-button
      class="mt-2"
      variant="primary"
      @click="$emit('deleteProduct', $event)"
    >
      Sim
    </b-button>
  </b-modal>
</template>

<script>
export default {
  name: "DeleteProductModal",
  props: {
    deleteModalShow: {
      required: true,
      type: Boolean
    }
  }
}
</script>

<style scoped>

</style>
