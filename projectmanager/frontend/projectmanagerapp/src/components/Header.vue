<template>
    <header>
        <h3>Project Manager</h3>  
        <div>
            <AddProjectButton :toggleForm="toggleForm" :text="toggleForm ? 'Close':'Add Task'"
                @toggle-add-project-form="this.$emit('toggle-add-project-form')" /> 
        </div>
    </header>
</template>

<script>
import AddProjectButton from './AddProjectButton.vue';

export default {
    name: 'Header',
    props: {
        toggleForm: Boolean
    },
    components: {
        AddProjectButton
    }
}
</script>

<style>
header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
}
</style>

