<template>
  <div :class="[getProjectStatus(project.projectStatus)]">
    <h3>
      {{ project.projectName }}
      <div class="component-allign">
        <i @click="changeProjectStatus" class="fa-solid fa-circle"></i>
        <i @click="showUpdateForm" class="fas fa-edit"></i>
        <i @click="this.$emit('delete-project', project.id)" class="fa-solid fa-x"></i>
      </div>
    </h3>
    <p>Status: {{ project.projectStatus }}</p>
    <p>Description: {{ project.description }}</p>
    <p>Creation Date: {{ project.creationDate }}</p>
    <div v-show="this.toggleUpdateForm">
      <EditForm @update-project="updateProject" :project="project" />
    </div>
  </div>


</template>

<script>
import EditForm from "./EditForm.vue"

export default {
  name: 'Project',
  props: {
    project: Object
  },
  components: {
    EditForm
  },
  data() {
    return {
      toggleUpdateForm: false
    }
  },
  methods: {
    changeProjectStatus() {
      this.$emit('change-project-status', this.project.id, this.project.projectName, this.project.projectStatus, this.project.description)
    },
    updateProject(projectId, projectName, description) {
      this.$emit('update-project', projectId, projectName, description)
    },
    showUpdateForm() {
      this.toggleUpdateForm = !this.toggleUpdateForm
    },
    getProjectStatus(status) {
      switch (status) {
        case 'NOTSTARTED': return 'project notstarted'
        case 'INDEVELOPMENT': return 'project indevelopment'
        case 'PAUSED': return 'project paused'
        case 'FINISHED': return 'project finished'
      }
    }
  }
}
</script>

<style scoped>
.component-allign {
  position: relative;
  float: right;
}

.fa-solid.fa-x {
  padding-left: 15px
}

.fa-solid {
  color: red;
}

.fa-solid.fa-circle {
  color: black;
}

.fas.fa-edit {
  color: black;
  padding-left: 15px
}

.project {
  background: #f4f4f4;
  margin: 5px;
  padding: 10px 20px;
  cursor: pointer;
}

.project.notstarted {
  border-left: 5px solid rgb(90, 79, 32);
}

.project.indevelopment {
  border-left: 5px solid rgb(78, 113, 211);
}

.project.paused {
  border-left: 5px solid rgb(190, 22, 22);
}

.project.finished {
  border-left: 5px solid green;
}
</style>