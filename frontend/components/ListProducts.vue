<template>
  <div>
    <b-table
      striped
      hover
      :fields="fields"
      :items="products"
      :busy="isBusy"
      :per-page="perPage"
      :current-page="currentPage"
    >
      <template #table-busy>
        <div class="text-center text-danger my-2">
          <b-spinner class="align-middle"></b-spinner>
          <strong>Loading...</strong>
        </div>
      </template>
      <template #cell(action)="data">
        <b-button
          aria-label="Editar"
          variant="primary"
          class="rounded-circle"
          v-b-tooltip.hover
          title="Editar Produto"
        >
          <font-awesome-icon :icon="['fas', 'pen']"/>
        </b-button>
        <b-button
          variant="danger"
          class="rounded-circle"
          @click="test(data.item.id)"
          v-b-tooltip.hover
          title="Remover Produto"
        >
          <font-awesome-icon :icon="['fas', 'trash']"/>
        </b-button>
        <b-button
          variant="success"
          class="rounded-circle"
          @click="registerStockMovement(data.item.id)"
          v-b-tooltip.hover
          title="Cadastrar movimentação"
        >
          <font-awesome-icon :icon="['fas', 'repeat']"/>
        </b-button>
        <b-button
          variant="success"
          class="rounded-circle"
          v-b-tooltip.hover
          title="Relatório de Vendas"
          @click="fetchProfitInfo(data.item.id)"
        >
          <font-awesome-icon :icon="['fas', 'sack-dollar']"/>
        </b-button>
      </template>
    </b-table>

    <DeleteProductModal
      @hideDeleteModal="updateDeleteShowModal"
      @deleteProduct="deleteProduct"
      :delete-modal-show="deleteModalShow"
    />

    <ReportModal
      @hideReportModal="updateReportModal"
      :profit-info="profitInfo"
      :profit-modal="profitModal"/>

    <RegisterStockMovement
      :product="this.product"
      :stock-show-modal="stockShowModal"
      @hideStockShowModal="updateStockShowModal"
    />

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
export default {
  name: "ListProducts",
  data() {
    return {
      fields: [
        { key: "code", label: "Codigo" },
        { key: "description", label: "Descrição" },
        { key: "type", label: "Tipo" },
        { key: "value", label: "Valor do Fornecedor" },
        { key: "amount", label: "Quantidade disponivel" },
        { key: "action", label: "Ações" }
      ],
      products: [],
      profitInfo: {
        outAmount: 0,
        profit: 0,
      },
      pageSize: [1, 5, 10, 15, 20, 25],
      perPage: 5,
      currentPage: 1,
      isBusy: true,
      deleteModalShow: false,
      profitModal: false,
      productId: 0,
      stockShowModal: false,
      product: {}
    }
  },
  computed: {
    rows() {
      return this.products.length;
    }
  },
  methods: {
    updateStockShowModal() {
      this.stockShowModal = !this.stockShowModal
    },
    updateDeleteShowModal() {
      this.deleteModalShow = !this.deleteModalShow;
    },
    updateAmountPerPage(value) {
      this.perPage = value;
    },
    updateCurrentPage(value) {
      this.currentPage = value;
    },
    updateReportModal() {
      this.profitModal = !this.profitModal
    },
    test(id) {
      this.deleteModalShow = true
      this.productId = id
    },
    async registerStockMovement(id) {
      this.product = await this.products.find(product => product.id === id)
      this.stockShowModal = true
    },
    async deleteProduct() {
      await this.$axios.delete(`products/${this.productId}`)
      const index = this.products.findIndex(product => product.id === this.productId);
      this.products.splice(index, 1)
      this.deleteModalShow = false;
      this.productId = 0
    },
    async fetchProfitInfo(id) {
      this.profitInfo = await this.$axios.$get(`products/${id}/profit`);
      console.log(this.profitInfo)
      this.profitModal = true
    }
  },
  async fetch() {
    this.products = await this.$axios.$get("products")
    this.isBusy = false
  }
}
</script>

<style scoped>

</style>
