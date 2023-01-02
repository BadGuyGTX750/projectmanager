<template>
  <div class="container">
    <Header />
    <AddProject @add-project="addProject" />
    <Projects @delete-project="deleteProject" :projectList="this.projectList" />
  </div>
</template>

<script>
import axios from 'axios'
import Header from './components/Header.vue'
import Projects from './components/Projects.vue'
import AddProject from './components/AddProject.vue'

export default{
  name: 'App',
  components: {
    Header,
    Projects,
    AddProject
  },
  data(){
    return {
      projectList: []
    }
  },
  created(){
    axios
      .get('http://localhost:8080/api/project/all')
      .then(response => {
        this.projectList = response.data
      })
      .catch(error => console.log(error))
  },
  methods: {
    addProject(project) {
      this.projectList.push(project)
      console.log(this.projectList)
    },
    async deleteProject(projectId){
      this.projectList = this.projectList.filter(project => project.id !== projectId )
      await axios.delete('http://localhost:8080/api/project/delete',
                                  { params: { id: projectId } })
    }
  }
}
</script>

<style>
.container {
  max-width: 500px;
  min-width: 450px;
  vertical-align: left;
  margin: 30px auto;
  overflow: auto;
  min-height: 300px;
  border: 1px solid steelblue;
  padding: 30px;
  border-radius: 5px;
}
</style>
