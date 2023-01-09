<template>
  <form @submit="onSubmit" class="add-form">
    <div class="form-control">
      <label>Project Name</label>
      <input type="text" v-model="projectName" name="text" placeholder="Add project" />
    </div>
    <div class="form-control">
      <label>Description</label>
      <input type="text" v-model="description" name="text" placeholder="Add description" />
    </div>
    <input type="submit" value="Save Project" class="btn btn-block" />
  </form>
</template>
  
<script>
import axios from 'axios'

export default {
  name: 'AddTask',
  data() {
    return {
      projectName: '',
      description: ''
    }
  },
  methods: {
    async onSubmit(e) {
      e.preventDefault()
      if (!this.projectName) {
        alert('Please add a project')
        return
      }
      const newProject = await axios.post('http://localhost:8080/api/project/add', {
        projectName: this.projectName,
        projectStatus: 'NOTSTARTED',
        description: this.description
      }).then().catch(error => { console.log(error); return })
      this.$emit('add-project', newProject.data)
      this.projectName = ''
      this.description = ''
    }
  }
}
</script>
  
<style scoped>
.btn.btn-block{
  display: inline-block;
  background: rgb(0, 0, 0);
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
.add-form {
  margin-bottom: 40px;
}

.form-control {
  margin: 20px 0;
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
