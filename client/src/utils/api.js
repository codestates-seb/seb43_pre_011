import axios from "axios";
axios.defaults.baseURL = "https://3.104.104.246";

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
    const response = await axios.post("/users/login", form, {
      headers: {
        "Content-Type": "application/json",
      },
      withCredentials: true,
    });
    console.log(response);
    console.log(`header ${response.headers.authorization}`);
    localStorage.setItem("accessToken", response.headers.authorization);
    localStorage.setItem("refreshToken", response.headers.Refresh);
    localStorage.setItem("userInfo", response.data.data); // 서버 연동후 수정 필요
    axios.defaults.headers.common[
      "Authorization"
    ] = `Bearer ${response.data.Authorization}`;
    return response.data;
  } catch (e) {
    if (e.response?.status === 401) {
      alert("비밀번호가 일치하지 않습니다.");
    } else {
      alert(e.response?.data.message);
    }
  }
};

export const DeleteApi = (type, id) => {
  try {
    axios.delete(`/${type}/${id}`);
    console.log("삭제요청 성공");
  } catch (e) {
    console.log(e);
  }
};
