import React from "react";
import { useFormik } from "formik";
import { TextField, Button, Box, Grid, Paper, Typography } from "@mui/material";
import { useNavigate } from "react-router-dom";
import { LoginSubmit } from "./LoginService";
import * as Yup from "yup";

const initialValues = {
  username: "",
  password: ""
} 

const validationSchema = Yup.object({
  username: Yup.string().min(2, "Enter a username").required(),
  password: Yup.string().min(2, "Enter your password").required()
})

export default function Login() {
  const navigate = useNavigate();   
  const handleNavClick = (destination) => {
    navigate(destination);
  };  

 const formik = useFormik({
    initialValues,
    validationSchema,
    onSubmit: async (values) => {
      if (LoginSubmit(values.username, values.password)) {
        navigate("/");
      }

    }});

  return (
    <form onSubmit={formik.handleSubmit}>
      <Box py={4} px={50}>
        <Paper elevation={10}>
          <Grid container className="loginForm" py={4} spacing={2}>

            <Grid container item xs={12} justifyContent="center">
              <Typography variant="h3">Login</Typography>
            </Grid>

            <Grid container item xs={12} justifyContent="center">
              <TextField
                id="username"
                name="username"
                label="Username"
                type="username"
                value={formik.values.username}
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                error={formik.touched && Boolean(formik.errors.username)}
              />
            </Grid>

            <Grid container item xs={12} justifyContent="center">
              <TextField
                id="password"
                name="password"
                label="Password"
                type="password"
                value={formik.values.password}
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                error={formik.touched && Boolean(formik.errors.password)}
              />
            </Grid>

            <Grid container item xs={12} justifyContent="center">
              <Button color="secondary" variant="contained" type="submit">
              Log In
            </Button>
            </Grid>
            <Grid container item xs={12} justifyContent="center">
              <Button color="primary" variant="contained"
                onClick={() => {
                  handleNavClick("/register");
                }}
              >
              Register
            </Button>
            </Grid>
          </Grid>
        </Paper>
      </Box>
    </form>
  );
}
