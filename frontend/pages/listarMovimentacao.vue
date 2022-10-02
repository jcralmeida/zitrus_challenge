<template>
  <div>
    <NavBarComponent/>
    <b-table
      :fields="fields"
      :items="stockMovement"
      striped
      hover
      :per-page="perPage"
      :current-page="currentPage"
    >
      <template #cell(salesDate)="data">
        <p>{{ formatDate(data.item.salesDate) }}</p>
      </template>
    </b-table>
    <TablePagination
      :page-size="pageSize"
      @amountPerPage="updateAmountPerPage"
      @currentPage="updateCurrentPage"
      :per-page="perPage"
      :rows="rows"
    />
  </div>
</template>

<script>
import dayjs from 'dayjs'
export default {
  name: "movimentacaoEstoque",
  data() {
    return {
      fields: [
        { key: "productId", label: "Identificação do Produto" },
        { key: "movement", label: "Tipo de Movimentação" },
        { key: "salesDate", label: "Data de venda" },
        { key: "amount", label: "Quantidade" },
        { key: "saleValue", label: "Valor de Venda" },
      ],
      stockMovement: [],
      pageSize: [1, 5, 10, 15, 20, 25],
      perPage: 5,
      currentPage: 1,
    }
  },
  computed: {
    rows() {
      return this.stockMovement.length;
    }
  },
  methods: {
    updateAmountPerPage(value) {
      this.perPage = value;
    },
    updateCurrentPage(value) {
      this.currentPage = value;
    },
    formatDate(date) {
      return dayjs(date);
    }
  },
  async fetch() {
    this.stockMovement = await this.$axios.$get("/stock_movements")
    this.isBusy = false
  }
}
</script>

<style scoped>

</style>
