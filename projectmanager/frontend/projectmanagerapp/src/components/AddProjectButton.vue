<template>
  <button @click="onClick" :class="chooseButtonClass()">{{ text }}</button>
</template>

<script>
export default {
  name: 'AddProjectButton',
  props: {
    text: String,
    toggleForm: Boolean
  },
  components: {

  },
  methods: {
    chooseButtonClass() {
      if(this.toggleForm == true)
        return "btn red"
      return "btn"
    },
    onClick() {
      this.$emit('toggle-add-project-form')
    }
  }
}
</script>

<style>
.btn {
  display: inline-block;
  background: rgb(40, 141, 15);
  color: #fff;
  border: none;
  padding: 10px 20px;
  margin: 5px;
  border-radius: 5px;
  cursor: pointer;
  text-decoration: none;
  font-size: 15px;
  font-family: inherit;
}
.btn.red {
  background: rgb(170, 0, 0);
}
</style>