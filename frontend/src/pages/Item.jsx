import {
  Button,
  Card,
  CardMedia,
  Container,
  CssBaseline,
  Grid,
  MenuItem,
  Paper,
  Select,
  ToggleButton,
  ToggleButtonGroup,
  Typography,
} from "@mui/material";
import * as React from "react";
import {
  getItemByName,
  convertParamToItemName,
} from "../Components/Items/ItemsService";
import { useParams, useNavigate } from "react-router-dom";
import { addToShoppingCart } from "../Components/ShoppingCart/CartService";
import { toast } from 'react-toastify';

function Item() {
  const sendToast = (message) => toast(message);
  const navigate = useNavigate();
  // Handles Product @Size and change item ---------{
  const [size, setSize] = React.useState("M");

  const handleSize = (event, newSize) => {
    if (newSize !== null) {
      setSize(newSize);
      let index = items.map((items) => items.productSize).indexOf(newSize);
      setSelectedItem(items[index]);
    }
  };
  // }--------------------------------------------------

  // Handles Product @Quantity ---------{
  const [quantity, setQuantity] = React.useState("1");

  const handleQuantity = (event) => {
    setQuantity(event.target.value);
  };
  // }---------------------------------------------------

  // Handles Add To Cart ------- {
  const handleAddToCart = () => {
    for (let i = 0; i < quantity; i++) {
      addToShoppingCart(selectedItem);
      sendToast("Added to cart!");
      navigate(-1);      
    }
  }

    // fetch for items on the items page
    const { itemParameterizedName } = useParams();
    // eslint-disable-next-line
    const [itemName, setItemName] = React.useState(
      convertParamToItemName(itemParameterizedName)
    );
    const [items, setItems] = React.useState([]);
    const [selectedItem, setSelectedItem] = React.useState([]);
    const [isLoading, setIsLoading] = React.useState(true);

    React.useEffect(() => {
      getItemByName(itemName).then((data) => {
        setItems(data);
        setSelectedItem(data[0]);
        setIsLoading(false);
      });
      // eslint-disable-next-line react-hooks/exhaustive-deps
    }, []);

    // Begin display
    if (isLoading) {
      return <p>Is loading</p>;
    }

    return (
      <>
        <CssBaseline>
          <Container maxWidth="lg" sx={{ pt: "40px" }}>
            <Paper elevation={3} maxWidth="500px">
              <Grid container spacing={2}>
                {/* This is the left side of the Paper */}
                {/* This contains on the Product @Photo */}

                <Grid
                  item
                  md={6}
                  sx={{
                    mb: "20px",
                  }}
                >
                  <Card>
                    <CardMedia
                      component="img"
                      height="700"
                      image={selectedItem.productImgUrl}
                    />
                  </Card>
                </Grid>
                <Grid item md={6} justifyContent="center">
                  <Grid
                    container
                    spacing={6}
                    direction="row"
                    justifyContent="center"
                  >
                    {/* Product @Name */}
                    <Grid item sm={12}>
                      <Typography variant="h2">{selectedItem.name}</Typography>
                    </Grid>

                    {/* Product @Size S M L XL */}
                    <Grid item sm={12} justifyContent="center">
                      <ToggleButtonGroup
                        color="secondary"
                        exclusive
                        value={size}
                        onChange={handleSize}
                      >
                        <ToggleButton value="S">S</ToggleButton>
                        <ToggleButton value="M">M</ToggleButton>
                        <ToggleButton value="L">L</ToggleButton>
                        <ToggleButton value="XL">XL</ToggleButton>
                      </ToggleButtonGroup>
                    </Grid>

                    {/* Product @Quantity */}
                    {/* Only goes from 1-3 */}
                    <Grid item sm={12}>
                      <Select
                        labelId="item-quantity-select-label"
                        id="item-quantity-select"
                        value={quantity}
                        label="Quantity"
                        onChange={handleQuantity}
                      >
                        <MenuItem value={1}>1</MenuItem>
                        <MenuItem value={2}>2</MenuItem>
                        <MenuItem value={3}>3</MenuItem>
                      </Select>
                    </Grid>

                    {/* Product @Price */}
                    <Grid item xs={12} justifyContent="center">
                      <Typography variant="h4">
                        {selectedItem.unit_price}
                      </Typography>
                    </Grid>

                    {/* @Add to Cart Button */}
                    <Grid
                      item
                      xs={12}
                      sm={12}
                      justifyContent="center"
                      justifyItems="center"
                    >
                      <Button
                        variant="contained"
                        color="secondary"
                        onClick={handleAddToCart}
                      >
                        Add to Cart
                      </Button>
                    </Grid>

                    {/* Product @Description */}
                    <Grid item sm={12}>
                      <Typography>{selectedItem.description}</Typography>
                    </Grid>
                  </Grid>
                </Grid>
              </Grid>
            </Paper>
          </Container>
        </CssBaseline>
      </>
    );
  };

export default Item;
