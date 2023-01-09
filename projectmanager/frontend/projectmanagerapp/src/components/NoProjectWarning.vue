<template>
    <div class="no-project-warning">
        <p>There are no projects to be shown.</p>
        <p>Click 'Add Project' and complete the form to add a project.</p>
    </div>
    
</template>


<script>
export default{
    name: 'NoProjectWarning',
}
</script>


<style>
.no-project-warning {
  background: #fff7b0;
  border-radius: 8px;
  margin: 5px;
  padding: 10px 20px;
  cursor: pointer;
  text-decoration: none;
  font-size: 15px;
  font-family: inherit;
}
</style>