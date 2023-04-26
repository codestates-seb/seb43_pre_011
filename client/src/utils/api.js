import axios from "axios";
axios.defaults.baseURL = "https://14e9af79fbfd.ngrok.app";

export const SignUpApi = async (form) => {
  try {
    const response = await axios.post("/members", form, {
      headers: {
        "Content-Type": "application/json",
      },
      "ngrok-skip-browser-warning": "69420",
    });
    return response;
  } catch (e) {
    alert(e.response?.data.message);
  }
};

export const LoginApi = async (form) => {
  try {
    const response = await axios.post("/api/users/login", form, {
      headers: {
        "Content-Type": "application/json",
      },
      withCredentials: true,
    });
    localStorage.setItem("token", response.data.access_token);
    localStorage.setItem("userInfo", response.data.data); // 서버 연동후 수정 필요
    axios.defaults.headers.common[
      "Authorization"
    ] = `Bearer ${response.data.access_token}`;
  } catch (e) {
    if (e.response?.status === 401) {
      alert("비밀번호가 일치하지 않습니다.");
    } else {
      alert(e.response?.data.message);
    }
  }
};
