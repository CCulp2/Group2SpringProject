import { Grid, Typography, CardActionArea } from "@mui/material";
import * as React from "react";
import Card from "@mui/material/Card";
import CardContent from "@mui/material/CardContent";
import CardMedia from "@mui/material/CardMedia";
import Box from "@mui/system/Box";
import Button from "@mui/material/Button";

function CartItem(props) {
  return (
    <Grid props xs={12}>
      <Card sx={{ display: "flex" }}>
        <Box sx={{ display: "flex", flexDirection: "column" }}>
          <CardActionArea>
            <CardMedia
              component="img"
              alt="Product Image"
              height="250"
              image={props.productImgUrl} 
              title="Product Image"
            />
          </CardActionArea>
        </Box>
        <Box
          sx={{
            display: "flex",
            alignItems: "center",
            pl: 1,
            pb: 1,
          }}
        >
          <CardContent sx={{ flex: "1 0 auto" }}>
            <Typography gutterBottom variant="h4" component="h4">
              {props.name}
            </Typography>
            <Typography gutterBottom variant="h5" component="h4">
              {props.unit_price}
            </Typography>
            <Typography gutterBottom variant="h5" component="h4">
              Size: {props.productSize}
            </Typography>
            <Button variant="outlined" color="secondary" onClick={() => props.handleRemove(props.cartId)}>
              Remove from Cart
            </Button>
          </CardContent>
        </Box>
      </Card>
    </Grid>
  );
}
export default CartItem;
