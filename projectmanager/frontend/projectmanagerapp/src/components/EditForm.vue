<template>
  <form @submit="onSubmit" class="add-form">
      <div class="form-control">
          <label>Project Name</label>
          <input type="text" v-model="projectName" name="text" placeholder="Change project" />
      </div>
      <div class="form-control">
          <label>Description</label>
          <input type="text" v-model="description" name="text" placeholder="Change description" />
      </div>
      <input type="submit" value="Update" class="btn btn-block" />
  </form>
</template>

<script>
import axios from 'axios'
import { toHandlers } from 'vue'
export default {
  name: "EditForm",
  props: {
    project: Object
  },
  data() {
    return {
      projectName: '',
      description: ''
    }
  },
  methods: {
    async onSubmit(e) {
      e.preventDefault()
      if(!this.projectName && !this.description)
      {
        alert('Please update at least one parameter')
        return
      }
      if(!this.projectName)
        this.$emit('update-project', this.project.id, this.project.projectName, this.description)
      if(!this.description)
        this.$emit('update-project', this.project.id, this.projectName, this.project.description)
      if(this.projectName && this.description)
        this.$emit('update-project', this.project.id, this.projectName, this.description)
      this.projectName = ''
      this.description = ''
    }
  }
}

</script>

<style scoped>
.add-form {
border-top: 1px solid #000000;
margin-top: 12px;
margin-bottom: 8px;
}

.form-control {
margin: 5px 0;
}

.form-control label {
display: block;
}

.form-control input {
width: 100%;
height: 40px;
margin: 5px;
padding: 3px 7px;
font-size: 17px;
}

.form-control-check {
display: flex;
align-items: center;
justify-content: space-between;
}

.form-control-check label {
flex: 1;
}

.form-control-check input {
flex: 2;
height: 20px;
}
</style>
