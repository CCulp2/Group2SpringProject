import {
  TextField,
  Button,
  Box,
  Grid,
  Paper,
  Typography,
  MenuItem,
} from "@mui/material";
import { useFormik } from "formik";
import * as Yup from "yup";
import React from "react";
import { addCustomer } from "./RegisterService";
import { stateAbbrev } from "./stateabbreviation";
import { toast } from 'react-toastify';
import { useNavigate } from "react-router";

const validationSchema = Yup.object({
  username: Yup.string().required("A Username is required"),
  password: Yup.string().required("Password is Required"),
  first_name: Yup.string()
    .required("Please enter a first name")
    .min(3, "Name must be at least 3 characters")
    .matches(/[A-Za-z]/, "Name can only contain letters."),
  last_name: Yup.string()
    .required("Please enter a last name")
    .min(3, "Name must be at least 3 characters")
    .matches(/[A-Za-z]/, "Name can only contain letters."),
  address: Yup.string()
    .required("Please enter a valid address")
    .min(5, "Please enter a valid address"),
  city: Yup.string()
    .required()
    .matches(/[A-Za-z]/, "City can only contain letters"),
  state: Yup.string().required("Must have a state selected."),
});

const initialValues = {
  username: "",
  password: "",
  first_name: "",
  last_name: "",
  address: "",
  city: "",
  state: "",
};

export default function Register() {
  const sendToast = (message) => toast(message);
  const navigate = useNavigate();
  const formik = useFormik({
    initialValues,
    validationSchema: validationSchema,
    onSubmit: (values) => {
      addCustomer(values);
      sendToast("You're all set!");
      navigate('/');
    }
  });

  return (
    <form onSubmit={formik.handleSubmit}>
      <Box className="registerForm" py={4} px={50}>
        <Paper elevation={10}>
          <Grid container spacing={2} py={4}>
            <Grid container item xs={12} justifyContent="center">
              <Typography variant="h3">Sign-Up</Typography>
            </Grid>

            {/* @Username */}
            <Grid container item xs={12} justifyContent="center">
              <TextField
                id="username"
                name="username"
                label="Username"
                type="username"
                varient="outlined"
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                value={formik.values.username}
                error={
                  formik.touched.username && Boolean(formik.errors.username)
                }
                helperText={formik.touched.username && formik.errors.username}
              />
            </Grid>

            {/* @Password */}
            <Grid container item xs={12} pb={4} justifyContent="center">
              <TextField
                id="password"
                name="password"
                label="Password"
                type="password"
                variant="outlined"
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                value={formik.values.password}
                error={
                  formik.touched.password && Boolean(formik.errors.password)
                }
                helperText={formik.touched.password && formik.errors.password}
              />
            </Grid>

            {/* @Name container */}
            <Grid
              container
              item
              xs={12}
              spacing={2}
              pb={4}
              justifyContent="center"
            >
              {/* @First name */}
              <Grid item>
                <TextField
                  id="first_name"
                  name="first_name"
                  label="First Name"
                  type="first_name"
                  varient="outlined"
                  onBlur={formik.handleBlur}
                  onChange={formik.handleChange}
                  value={formik.values.first_name}
                  error={
                    formik.touched.first_name && Boolean(formik.errors.first_name)
                  }
                  helperText={
                    formik.touched.first_name && formik.errors.first_name
                  }
                />
              </Grid>

              {/* @Last name */}
              <Grid item>
                <TextField
                  id="last_name"
                  name="last_name"
                  label="Last Name"
                  type="last_name"
                  varient="outlined"
                  onBlur={formik.handleBlur}
                  onChange={formik.handleChange}
                  value={formik.values.last_name}
                  error={
                    formik.touched.last_name && Boolean(formik.errors.last_name)
                  }
                  helperText={formik.touched.last_name && formik.errors.last_name}
                />
              </Grid>
            </Grid>

            {/* @Address container */}
            <Grid container item xs={12} spacing={2} justifyContent="center">
              {/* Street Address */}
              <Grid item>
                <TextField
                  id="address"
                  label="Street Address"
                  name="address"
                  type="address"
                  varient="outlined"
                  onBlur={formik.handleBlur}
                  onChange={formik.handleChange}
                  value={formik.values.address}
                  error={
                    formik.touched.address &&
                    Boolean(formik.errors.address)
                  }
                  helperText={
                    formik.touched.address && formik.errors.address
                  }
                />
              </Grid>

              {/* @City */}
              <Grid item>
                <TextField
                  id="city"
                  label="City"
                  name="city"
                  type="city"
                  varient="outlined"
                  onBlur={formik.handleBlur}
                  onChange={formik.handleChange}
                  value={formik.values.city}
                  error={formik.touched.city && Boolean(formik.errors.city)}
                  helperText={formik.touched.city && formik.errors.city}
                />
              </Grid>
            </Grid>

            {/* @State */}
            <Grid container item xs={12} justifyContent="center">
              <TextField
                sx={{minWidth: 120}}

                select
                id="state"
                label="State"
                name="state"
                type="state"
                varient="outlined"
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                value={formik.values.state}
                error={formik.touched.state && Boolean(formik.errors.state)}
                helperText={formik.touched.state && formik.errors.state}
              >
                {stateAbbrev.map((option) => (
                  <MenuItem
                    key={option.abbreviation}
                    value={option.abbreviation}
                  >
                    {option.name}
                  </MenuItem>
                ))}
              </TextField>
            </Grid>
            

            <Grid container item xs={12} justifyContent="center">
              <Button color="primary" variant="contained" type="submit">
                Submit
              </Button>
            </Grid>
          </Grid>
        </Paper>
      </Box>
    </form>
  );
}
