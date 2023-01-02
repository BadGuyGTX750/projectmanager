<template>
    <header>
        <h1>{{title}}</h1>
        <Button @taskGetAll="sendToHeader" text="Get Tasks" color="green" />
    </header>
</template>

<script>
import Button from './Button.vue';
export default {
    name: 'Header',
    props: {
        title: String,
    },
    components: {
    Button,
    },
    data(){
        return {
            tasks: []
        }
    },
    methods: {
        sendToHeader(value) {
            this.tasks = value
            this.$emit('taskGetAll', this.tasks)
        }
    }
}
</script>

<style scoped>
header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
}
</style>