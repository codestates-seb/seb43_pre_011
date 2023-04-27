import { atom, selector } from "recoil";
import axios from "axios";
axios.defaults.baseURL = "https://4256dbf9a9eb.ngrok.app";

export const questionState = atom({
  key: "questionState",
  default: [],
});

export const getQuestionSelector = selector({
  key: "question/get",
  get: async ({ get }) => {
    try {
      const { data } = await axios.get("/questions?page=1&size=100", {
        headers: {
          "ngrok-skip-browser-warning": "69420",
        },
      });
      return data.data;
    } catch (err) {
      console.log(err);
      throw err;
    }
  },
  set: ({ set }, newValue) => {
    set(questionState, newValue);
  },
});

export const membersState = atom({
  key: "membersState",
  default: [],
});

export const getMembersSelector = selector({
  key: "members/get",
  get: async ({ get }) => {
    try {
      const { data } = await axios.get("/members?page=1&size=100", {
        headers: {
          "ngrok-skip-browser-warning": "69420",
        },
      });
      return data.data;
    } catch (err) {
      console.log(err);
      throw err;
    }
  },
  set: ({ set }, newValue) => {
    set(membersState, newValue);
  },
});
