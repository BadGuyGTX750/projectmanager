<template>
    <header>
        <h3>Project Manager</h3>  
        <AddProjectButton /> 
    </header>
</template>

<script>
import AddProjectButton from './AddProjectButton.vue';

export default {
    name: 'Header',
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

