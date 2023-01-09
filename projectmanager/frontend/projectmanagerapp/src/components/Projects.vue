<template>
    <div :key="project.id" v-for="project in projectList">
        <Project @change-project-status="changeProjectStatus" @update-project="updateProject" @delete-project="this.$emit('delete-project', project.id)" :project="project"/>
    </div>
</template>

<script>
import Project from './Project.vue'

export default {
    name: 'Projects',
    props: {
        projectList: Array
    },
    components: {
        Project
    },
    methods: {
      changeProjectStatus(projectId, projectName, projectStatus, description) {
        this.$emit('change-project-status', projectId, projectName, projectStatus, description)
      },
      updateProject(projectId, projectName, description) {
          this.$emit('update-project', projectId, projectName, description)
        }
    }
}
</script>

<style>
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