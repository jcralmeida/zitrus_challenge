<template>
  <b-modal
    v-model="profitModal"
    hide-footer
    title="Relatorio de vendas"
    @hide="$emit('hideReportModal', $event)"
  >
    <div v-if="profitInfo" class="d-block text-left">
      <h5>Quantidade Comercializada - {{ profitInfo.outAmount }} items</h5>
      <h5>Lucro - R$ {{ profitInfo.profit }}</h5>
    </div>
    <div v-else>
      <h5>Sem dados de movimentação</h5>
    </div>
  </b-modal>
</template>

<script>
export default {
  name: "ReportModal",
  props: {
    profitModal: {
      required: true,
      type: Boolean
    },
    profitInfo: {
      required: true,
      type: Object
    }
  }
}
</script>

<style scoped>

</style>
