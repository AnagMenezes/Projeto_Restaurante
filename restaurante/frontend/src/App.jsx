import { BrowserRouter, Routes, Route } from 'react-router-dom'

import Navbar from './components/Navbar/Navbar'
import Home from './pages/Home/Home'
import Cardapio from './pages/Cardapio/Cardapio'
import CardapioCategoria from './pages/CardapioCategoria/CardapioCategoria'
import Sobre from './pages/Sobre/Sobre'

import Admin from './pages/Admin/Admin'
import Categorias from './pages/Categorias/Categorias'
import Produtos from './pages/Produtos/Produtos'

import Footer from './components/Footer/Footer'
import Promocoes from './pages/Promocoes/Promocoes'
import Eventos from './pages/Eventos/Eventos'

function App() {
  return (
    <BrowserRouter>

      <Navbar />

      <Routes>

        <Route path="/" element={<Home />} />

        <Route path="/cardapio" element={<Cardapio />} />

        <Route
          path="/cardapio/categoria/:id"
          element={<CardapioCategoria />}
        />

        <Route path="/sobre" element={<Sobre />} />

        <Route path="/promocoes" element={<Promocoes />} />

        <Route path="/eventos" element={<Eventos />} />

        <Route path="/admin" element={<Admin />} />

        <Route
          path="/admin/categorias"
          element={<Categorias />}
        />

        <Route
          path="/admin/produtos"
          element={<Produtos />}
        />

      </Routes>

      <Footer />

    </BrowserRouter>
  )
}

export default App