<template>
  <b-modal v-model="stockShowModal" @hide="$emit('hideStockShowModal', $event)" hide-footer>
    <b-form @submit.prevent="postStockMovement">
      <h4>Criando movimentação de estoque para {{ this.product.description }}</h4>

      <hr />

      <label class="mt-1" for="Name">Selecione o tipo da movimentação</label>
      <b-form-select
        v-model="movementStock.movement"
        :options="movementType"
        class="shadow my-2"
      />
      <div v-if="movementStock.movement === 'SAIDA'">
        <label for="Name">Valor total de venda</label>
        <b-form-input
          v-model="movementStock.saleValue"
          class="shadow mb-3"
          type="money"
          placeholder="Digite o valor total da venda"
        />
      </div>
      <label for="MovementDate">Data da Movimentação</label>
      <b-form-datepicker
        v-model="movementStock.salesDate"
        class="shadow mb-3"
      />
      <label for="Name">Quantidade</label>
      <b-form-input
        v-model="movementStock.amount"
        class="shadow mb-3"
        type="number"
        placeholder="Digite a quantidade de produto usado na operação"
      />
      <b-button
        class="mt-3"
        type="submit"
        variant="primary"
      >
        Salvar Movimentação
      </b-button>
    </b-form>
  </b-modal>
</template>

<script>
export default {
  name: "RegisterStockMovement",
  props: {
    stockShowModal: {
      required: true,
      type: Boolean
    },
    product: {
      required: true,
      type: Object
    }
  },
  data() {
    return {
      movementStock: {
        saleValue: 0,
        movement: "",
        amount: 0,
        salesDate: "",
      },
      movementType: [
        { value: "ENTRADA", text: "Entrada" },
        { value: "SAIDA", text: "Saida"}
      ],
    }
  },
  methods: {
    async postStockMovement() {
      const body = {...this.movementStock, productId: this.product.id}
      await this.$axios.$post('http://localhost:8080/api/stock_movements', body)
      this.$emit('hideStockShowModal');
      this.movementStock.saleValue= 0;
      this.movementStock.movement= "";
      this.movementStock.amount= 0;
      this.movementStock.salesDate= "";
    },
  },
}
</script>

<style scoped>

</style>
