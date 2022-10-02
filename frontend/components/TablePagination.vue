<template>
  <b-row>
    <b-col class="col-2">
      <b-form-select
        @input="$emit('amountPerPage', $event)"
        v-model="perPage"
        :options="pageSize"
      ></b-form-select>
    </b-col>
    <b-col>
      <b-pagination
        @input="$emit('currentPage', $event)"
        :total-rows="rows"
        :per-page="perPage"
        aria-controls="my-table"
      />
    </b-col>
  </b-row>
</template>

<script>
export default {
  name: "TablePagination",
  props: {
    pageSize: {
      required: true,
      type: Array,
    },
    rows: {
      required: true,
      type: Number,
    },
    perPage: {
      required: true,
      type: Number,
    },
  },
}
</script>

<style scoped>

</style>
