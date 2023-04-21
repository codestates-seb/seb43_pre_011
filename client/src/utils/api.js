import axios, { AxiosError } from "axios";

export const SignUpApi = async (form) => {
  try {
    const response = await axios.post("/users/signup", form, {
      headers: {
        "Content-Type": "application/json",
      },
    });
    return response;
  } catch (e) {
    alert(e.response?.data.message);
  }
};
