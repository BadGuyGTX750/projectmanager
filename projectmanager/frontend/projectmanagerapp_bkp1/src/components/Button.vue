<template>
    <button @click="getTasks" :style="{background: color}" class="btn">
        {{ text }}
    </button>
</template>

<script>
import axios from 'axios'

export default{
    name: 'Button',
    props: {
        text: String,
        color: String
    },
    data() {
        return {
            tasks: []
        }
    },
    methods: {
        async getTasks() {
            axios.get('http://localhost:8080/api/task/all')
                .then((response) => {
                    console.log(response.data)
                    this.tasks = response.data
                    this.$emit('taskGetAll', this.tasks)
                })
                .catch((error) => {
                    console.log(error)
                })
        }, 
    },
}
</script>
