import { CssBaseline, Grid, Typography } from "@mui/material";
import Paper from "@mui/material/Paper";
import { useState } from "react";
import { useLocation } from "react-router-dom";
import { currentLoggedInCustomer } from "../Customer/CustomerService";

// This is the confirmation page, which is displayed after the user has completed an order.

function Confirmation() {
  const [customer, setCustomer] = useState(currentLoggedInCustomer());

  const order = useLocation();

  return (
    <CssBaseline>
      <Paper elevation={3} sx={{ maxWidth: 750, marginX: "auto", marginY: 15 }}>
        <Grid container spacing={10}>
          <Grid item xs={12}>
            <Typography
              variant="h3"
              align="center"
              color="secondary"
              fontWeight="bold"
            >
              {"Thank you for your order, " + customer[0].firstName + "!"}
            </Typography>
          </Grid>
          <Grid item xs={12}>
            <Typography variant="h4" align="center">
              Your order number is:
            </Typography>
          </Grid>

          {/* @OrderNumber */}
          <Grid item xs={12}>
            <Typography
              variant="h4"
              align="center"
              fontWeight="bold"
              color="secondary"
            >
              {order.state.submittedOrder.orderID}
            </Typography>
            <Typography variant="h4" align="center">
              and was placed on
            </Typography>
            <Typography
              variant="h4"
              align="center"
              fontWeight="bold"
              color="secondary"
            >
              {order.state.submittedOrder.orderDate}
            </Typography>
          </Grid>

          <Grid item xs={12}>
            <Typography variant="h6" align="center">
              If you have any questions, please call us at 1-800-555-1234.
            </Typography>
          </Grid>
          <Grid item xs={12}>
            <Typography
              variant="h6"
              align="center"
              fontWeight="bold"
              sx={{ pb: 10 }}
            >
              Thank you for shopping with us!
            </Typography>
          </Grid>
        </Grid>
      </Paper>
    </CssBaseline>
  );
}

export default Confirmation;
