<template>
  <div class="container">
    <Header :toggleForm="this.showAddProjectForm" @toggle-add-project-form="toggleAddProjectForm" />
    <div v-if="showNoProjectWarningFun()">
      <NoProjectWarningVue />
    </div>
    <div v-show="this.showAddProjectForm">
      <AddProject @add-project="addProject" />
    </div>
    <Projects @change-project-status="changeProjectStatus" @update-project="updateProject" @delete-project="deleteProject" :projectList="this.projectList" />
  </div>
</template>

<script>
import axios from 'axios'
import Header from './components/Header.vue'
import Projects from './components/Projects.vue'
import AddProject from './components/AddProject.vue'
import NoProjectWarningVue from './components/NoProjectWarning.vue'

export default{
  name: 'App',
  components: {
    Header,
    Projects,
    AddProject,
    NoProjectWarningVue
  },
  data(){
    return {
      projectList: [],
      showAddProjectForm: false
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
    async changeProjectStatus(projectId, projectName, projectStatus, description) {
      let status = 0
      if (projectStatus == 'NOTSTARTED')
        status = 1
      if (projectStatus == 'INDEVELOPMENT')
        status = 2
      if (projectStatus == 'PAUSED')
        status = 3
      if (projectStatus == 'FINISHED')
        status = 0
      const updatedProject = await axios.put('http://localhost:8080/api/project/update',{
        'id': projectId,
        'projectName': projectName,
        "projectStatus": status,
        'description': description
      })
      let indexToDeleteFrom = this.projectList.findIndex(project => project.id === projectId)
      this.projectList = this.projectList.filter(project => project.id !== projectId)
      this.projectList.splice(indexToDeleteFrom, 0, updatedProject.data)
      //this.projectList.push(updatedProject.data)
    },
    showNoProjectWarningFun() {
      if(this.projectList.length == 0)
        return true
      return false
    },
    async updateProject(projectId, projectName, description) {
      const updatedProject = await axios.put('http://localhost:8080/api/project/update',{
        'id': projectId,
        'projectName': projectName,
        "projectStatus": 0,
        'description': description
      })
      this.projectList = this.projectList.filter(project => project.id !== projectId)
      this.projectList.push(updatedProject.data)
    },
    toggleAddProjectForm() {
      this.showAddProjectForm = !this.showAddProjectForm
    },
    addProject(project) {
      this.projectList.push(project)
      console.log(this.projectList)
    },
    async deleteProject(projectId){
      this.projectList = this.projectList.filter(project => project.id !== projectId)
      await axios.delete('http://localhost:8080/api/project/delete',
                                  { params: { id: projectId } })
    }
  }
}
</script>

<style>
.container {
  max-width: 700px;
  min-width: 600px;
  vertical-align: left;
  margin: 30px auto;
  overflow: auto;
  min-height: 200px;
  border: 1px solid steelblue;
  padding: 30px;
  border-radius: 5px;
}
</style>
