<template>
    <div :class="[getProjectStatus(project.projectStatus)]">
        <h3>
          {{ project.projectName }}
          <i @click="this.$emit('delete-project', project.id)" 
              class="fa-solid fa-x"></i>
        </h3>
        <p>Creation Date:  {{ project.creationDate }}</p>
        
    </div>
</template>

<script>


export default {
    name: 'Project',
    props: {
        project: Object
    },
    components: {

    },
    methods: {
        getProjectStatus(status) {
            switch(status) {
                case 'NOTSTARTED': return 'project notstarted'
                case 'INVDEVELOPMENT': return 'project indevelopment'
                case 'PAUSED': return 'project paused'
                case 'FINISHED': return 'project finished'
            }
        }
    }
}
</script>

<style scoped>
.fa-solid {
  color: red;
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