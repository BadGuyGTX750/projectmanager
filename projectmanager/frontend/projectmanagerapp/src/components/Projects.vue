<template>
    <div :key="project.id" v-for="project in projectList">
        <Project @delete-project="this.$emit('delete-project', project.id)" :project="project"/>
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
    }
}
</script>

<style>

</style>