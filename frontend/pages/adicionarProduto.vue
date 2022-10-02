<template>
  <div>
    <NavBarComponent/>
    <b-container fluid style="height: 80vh; width: 100vh">
    <b-form @submit.prevent="save">
      <label class="mt-3" for="Name">Descrição do Produto</label>
      <b-form-input
        v-model="product.description"
        class="mb-3 shadow"
        placeholder="Digite uma breve descrição do Produto"
      />
      <label for="Name">Valor do Fornecedor</label>
      <b-form-input
        v-model="product.value"
        class="shadow mb-3"
        type="money"
        placeholder="Digite o valor no Fornecedor"
      />
      <label for="Name">Quantidade</label>
      <b-form-input
        v-model="product.amount"
        class="shadow mb-3"
        type="number"
        placeholder="Digite a quantidade disponivel em estoque"
      />
      <label class="mt-1" for="Name">Selecione o Tipo do Produto</label>
      <b-form-select
        v-model="product.type"
        :options="productType"
        class="shadow my-2"
      />
      <b-button
        class="mt-3"
        type="submit"
        variant="primary"
      >
        Salvar
      </b-button>
    </b-form>
    <b-alert
      class="mt-3"
      v-model="showSaveAlert"
      variant="success"
      dismissible
    >
      Congratulations. Produto salvo com sucesso.
    </b-alert>
  </b-container>
  </div>
</template>

<script>
export default {
  name: 'adicionarProduto',
  data() {
    return {
      product: {
        description: '',
        type: '',
        value: 0,
        amount: 0,
      },
      productType: [
        { value: 'ELETRONICO', text: 'Eletrônico' },
        { value: 'ELETRODOMESTICO', text: 'Eletrodomestico' },
        { value: 'MOVEL', text: 'Movel' },
      ],
      showSaveAlert: false,
    }
  },
  methods: {
    async save() {
      await this.$axios.post('/products', this.product)
        .then(value => this.showSaveAlert = true)
        .catch(reason => console.log("Erro ao salvar"))

      this.resetProduct()
    },
    resetProduct() {
      this.product.description= '',
      this.product.type= '',
      this.product.value= 0,
      this.product.amount= 0
    }
  },
}
</script>

<style scoped></style>
